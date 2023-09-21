package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Crop;

/**
 * Data Transfer Object (DTO) representing the Crop entity.
 */
public record CropDto(Long id, String name, Double plantedArea, Long farmId) {

  /**
   * Creates a CropDto from a Crop entity.
   *
   * @param crop The Crop entity to convert.
   * @return A CropDto populated with data from the Crop entity.
   */
  public static CropDto fromEntity(Crop crop) {
    Long farmId = crop.getFarm() != null ? crop.getFarm().getId() : null;
    return new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(), farmId);
  }

  /**
   * Converts the CropDto to a Crop entity.
   *
   * @return A Crop entity with the same attributes as this DTO.
   */
  public Crop toEntity() {
    Crop crop = new Crop();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    return crop;
  }
}
