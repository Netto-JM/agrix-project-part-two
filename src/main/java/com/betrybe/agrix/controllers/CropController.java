package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.services.CropService;
import com.betrybe.agrix.services.exception.CropNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing Crop entities.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Retrieves a list of all Crop entities.
   *
   * @return A list of CropDto objects representing all Crop entities.
   */
  @GetMapping()
  public List<CropDto> getAllCrops() {
    List<Crop> allCrops = cropService.getAllCrops();
    return allCrops.stream().map(CropDto::fromEntity).toList();
  }

  /**
   * Retrieves a crop by its unique identifier.
   *
   * @param cropId The unique identifier of the crop to retrieve.
   * @return ResponseEntity containing a CropDto if the crop is found.
   * @throws CropNotFoundException If the crop with the specified ID is not found.
   */
  @GetMapping("/{cropId}")
  public ResponseEntity<CropDto> getCropById(@PathVariable Long cropId)
      throws CropNotFoundException {
    Optional<Crop> optionalCrop = cropService.getCropById(cropId);

    return optionalCrop.map(crop -> ResponseEntity.ok(CropDto.fromEntity(crop)))
        .orElseThrow(CropNotFoundException::new);
  }

  /**
   * Retrieves a list of all Crop entities that have a harvest date between the specified dates.
   *
   * @param start The start date of the harvest date range.
   * @param end   The end date of the harvest date range.
   * @return A list of CropDto objects representing all Crop entities that have a harvest date
   *         between the specified dates.
   */
  @GetMapping("/search")
  public List<CropDto> getByHarvestDate(
      @RequestParam LocalDate start,
      @RequestParam LocalDate end
  ) {
    List<Crop> allCrops = cropService.getByHarvestDate(start, end);
    return allCrops.stream().map(CropDto::fromEntity).toList();
  }
}
