package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dennis on 23.06.2017.
 */
public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (instance == null)
            instance = new StatisticManager();
        return instance;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();
            storage.put(EventType.COOKED_ORDER, new ArrayList<EventDataRow>());
            storage.put(EventType.SELECTED_VIDEOS, new ArrayList<EventDataRow>());
            storage.put(EventType.NO_AVAILABLE_VIDEO, new ArrayList<EventDataRow>());
        }

        private void put(EventDataRow data) {
            switch (data.getType()) {
                case COOKED_ORDER:
                    storage.get(EventType.COOKED_ORDER).add(data);
                    break;
                case SELECTED_VIDEOS:
                    storage.get(EventType.SELECTED_VIDEOS).add(data);
                    break;
                case NO_AVAILABLE_VIDEO:
                    storage.get(EventType.NO_AVAILABLE_VIDEO).add(data);
                    break;
            }
        }
    }
}
