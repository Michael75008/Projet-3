package com.openclassrooms.entrevoisins.service;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }
/*
    @Override
    public List<Neighbour> getFavoriteNeighbours() {
    if(isFavorite == true){
    return neighbour}
    else {return null}

*/
}
