package com.openclassrooms.entrevoisins.service;

import android.accounts.NetworkErrorException;
import android.widget.CheckBox;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourPagerAdapter;
import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

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
     * {@inheritDoc}
     *
     * @return favorite neighbour
     */

    public List<Neighbour> getFavoriteNeighbours() {
        List<Neighbour> currentNeighbours = new ArrayList<>();
        for (int i = 0; i < neighbours.size(); i++) {
            Neighbour currentNeighbour = neighbours.get(i);
            if (currentNeighbour.getFavorite()) {
                currentNeighbours.add(currentNeighbour);
            }
        }
        return currentNeighbours;
    }

    /**
     * {@inheritDoc}
     *
     * @param neighbour (favorite)
     */


    public void updateFavoriteNeighbour(Neighbour neighbour) {
        for (int i = 0; i < neighbours.size(); i++) {
            Neighbour currentNeighbour = neighbours.get(i);
            if (currentNeighbour.getId() == neighbour.getId()) {
                currentNeighbour.setFavorite(neighbour.getFavorite());
            }
        }
    }
}
