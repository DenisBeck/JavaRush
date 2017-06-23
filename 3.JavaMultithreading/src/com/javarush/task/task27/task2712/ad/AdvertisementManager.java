package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Dennis on 23.06.2017.
 */
public class AdvertisementManager {
    private int timeSeconds;
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException{
        List<Advertisement> candidates = new ArrayList<>();
        //Include only compatible by duration video
        for (Advertisement ad: storage.list()) {
            if (ad.getDuration() <= timeSeconds && ad.getHits() > 0)
                candidates.add(ad);
        }

        //If no one compatible
        if (candidates.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        //Select optimal video set by exhaustive search
        OptimalVideoSet optimalVideoSet = new OptimalVideoSet(candidates, timeSeconds);
        List<Advertisement> optimalVideoList = optimalVideoSet.getOptimalVideoSet();
        //Sort video playlist
        Collections.sort(optimalVideoList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (int) (o1.getAmountPerOneDisplaying() == o2.getAmountPerOneDisplaying()
                        ? (o1.getAmountPerSecond() - o2.getAmountPerSecond()) * 1000000
                        : o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
            }
        });

        //Register event before showing videos
        StatisticManager.getInstance().register(
                new VideoSelectedEventDataRow(
                        optimalVideoList,
                        optimalVideoSet.getOptimalVideoSetAmount(),
                        optimalVideoSet.getOptimalVideoSetDuration()
                )
        );

        //Show videos & update ads' data
        for (int i = 0; i < optimalVideoList.size(); i++) {
            Advertisement showingAd = optimalVideoList.get(i);
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                    showingAd.getName(),
                    showingAd.getAmountPerOneDisplaying(),
                    (int)(showingAd.getAmountPerSecond() * 1000)
            ));
            showingAd.revalidate();

        }
    }

    private class OptimalVideoSet  {
        private int toShowTimeSeconds;
        private CopyOnWriteArrayList<Advertisement> candidates_ = new CopyOnWriteArrayList<>();

        private int optimalVideoSetAmount = 0;
        private int optimalVideoSetTime = 0;
        private CopyOnWriteArrayList<Advertisement> optimalVideoSet;


        public OptimalVideoSet(List<Advertisement> candidates, int toShowTimeSeconds) {
            this.toShowTimeSeconds = toShowTimeSeconds;
            this.candidates_.addAll(candidates);
        }

        public List<Advertisement> getOptimalVideoSet() {
            Sortout(candidates_);
            List<Advertisement> result = new ArrayList<>();
            result.addAll(optimalVideoSet);
            return result;
        }

        //exhaustive search
        private void Sortout(CopyOnWriteArrayList<Advertisement> candidates) {
            CopyOnWriteArrayList<Advertisement> currentList = candidates;
            //Calculate current video set parameters
            int amountOfAd = 0;
            int sumOfAdTime = 0;
            for (Advertisement ad : currentList) {
                amountOfAd += ad.getAmountPerOneDisplaying();
                sumOfAdTime += ad.getDuration();
            }
            //If video set is too long eliminate each video
            // & invoke optimal set finding in recursion sequentially
            if (sumOfAdTime > toShowTimeSeconds)
                for (int i = currentList.size() - 1; i >= 0; i--) {
                    candidates = (CopyOnWriteArrayList<Advertisement>) currentList.clone();
                    candidates.remove(i);
                    Sortout(candidates);
                }
            else {
                //Replace optimal result if current set is better
                if (amountOfAd > optimalVideoSetAmount) {
                    optimalVideoSet = currentList;
                } else if (amountOfAd == optimalVideoSetAmount)
                    if (sumOfAdTime > optimalVideoSetTime)
                        optimalVideoSet = currentList;
                    else if (sumOfAdTime == optimalVideoSetTime)
                        if (currentList.size() < optimalVideoSet.size())
                            optimalVideoSet = currentList;
                if (optimalVideoSet == currentList) {
                    optimalVideoSetAmount = amountOfAd;
                    optimalVideoSetTime = sumOfAdTime;
                }
            }
        }

        public int getOptimalVideoSetDuration() {
            return optimalVideoSetTime;
        }

        public int getOptimalVideoSetAmount() {
            return optimalVideoSetAmount;
        }
    }

    /*public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty())
            throw new NoVideoAvailableException();
        Collections.sort(storage.list(), new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = (int) (o1.getAmountPerOneDisplaying() - o2.getAmountPerOneDisplaying());
                if (result != 0)
                    return result;
                int oneSecondCost1 = (int) (o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration());
                int oneSecondCost2 = (int) (o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
                result = oneSecondCost2 - oneSecondCost1;
                return result;
            }
        });
        int timeLeft = timeSeconds;
        for (Advertisement advertisement : storage.list()) {
            if (timeLeft < advertisement.getDuration()) {
                continue;
            }

            ConsoleHelper.writeMessage(advertisement.toString());

            timeLeft -= advertisement.getDuration();
            advertisement.revalidate();
        }

        if (timeLeft == timeSeconds) {
            throw new NoVideoAvailableException();
        }*/
        /*Collections.sort(storage.list(), new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0)
                    return -result;

                long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();

                return Long.compare(oneSecondCost1, oneSecondCost2);
            }
        });

        int timeLeft = timeSeconds;
        for (Advertisement advertisement : storage.list()) {
            if (timeLeft < advertisement.getDuration()) {
                continue;
            }

            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());

            timeLeft -= advertisement.getDuration();
            advertisement.revalidate();
        }

        if (timeLeft == timeSeconds) {
            throw new NoVideoAvailableException();
        }
    }*/


}
