package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.repositories.CropRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing Crop entities.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;

  @Autowired
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }

  /**
   * Retrieves a crop by its unique identifier.
   *
   * @param id The unique identifier of the crop to retrieve.
   * @return An Optional containing the retrieved Crop entity,
   *         or an empty Optional if no crop with the specified ID is found.
   */
  public Optional<Crop> getCropById(Long id) {
    return cropRepository.findById(id);
  }

  /**
   * Retrieves all Crop entities from the database.
   *
   * @return A List containing all Crop entities.
   */
  public List<Crop> getAllCrops() {
    return cropRepository.findAll();
  }

  /**
   * Retrieves a list of Crop entities with harvest dates between specified start and end dates,
   * inclusively.
   *
   * @param start The start date for filtering crops.
   * @param end   The end date for filtering crops.
   * @return A List containing Crop entities with harvest dates between start and end dates,
   *         inclusively.
   */
  public List<Crop> getByHarvestDate(LocalDate start, LocalDate end) {
    return cropRepository.findByHarvestDateBetween(start, end);
  }
}
