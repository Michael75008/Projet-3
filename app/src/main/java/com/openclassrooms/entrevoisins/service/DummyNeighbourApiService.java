package com.openclassrooms.entrevoisins.service;

import android.widget.CheckBox;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourPagerAdapter;
import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     *
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    /**
     * Get Favorite Neighbour List
     */

    public List<Neighbour> getFavoriteNeighbours() {
        List<Neighbour> currentNeighbours = new ArrayList<>();
        for (int i = 0; i < neighbours.size(); i++) {
            Neighbour currentNeighbour = neighbours.get(i);
            if (currentNeighbour.getFavorite()) {
                neighbours.add(currentNeighbour);
            }
        }
        return currentNeighbours;
    }
}
    /**
     * Update Favorite Neighbour List
     *
     */
