package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Creates a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Get all my favorite Neighbours
     * @return
     */

    List<Neighbour> getFavoriteNeighbours();

    /**
     * Updates favorite Neighbour state
     * @param neighbour
     */

    void updateFavoriteNeighbour(Neighbour neighbour);
}
