package com.betrybe.agrix.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Represents a crop entity.
 */
@Entity
@Table(name = "crop")
public class Crop {

  /**
   * The unique identifier of the crop.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * The name of the crop.
   */
  private String name;

  /**
   * The planted area of the crop in acres.
   */
  @Column(name = "planted_area")
  private Double plantedArea;

  /**
   * The farm to which this crop belongs.
   */
  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;

  // Construtores, getters e setters

  // Construtor vazio
  public Crop() {}

  // Construtor parametrizado
  /**
   * Parameterized constructor for Crop.
   *
   * @param id          The unique identifier of the crop.
   * @param name        The name of the crop.
   * @param plantedArea The planted area of the crop in acres.
   * @param farm        The farm to which this crop belongs.
   */
  public Crop(Long id, String name, Double plantedArea, Farm farm) {
    this.id = id;
    this.name = name;
    this.plantedArea = plantedArea;
    this.farm = farm;
  }

  /**
   * Get the unique identifier of the crop.
   *
   * @return The unique identifier of the crop.
   */
  public Long getId() {
    return id;
  }

  /**
   * Set the unique identifier of the crop.
   *
   * @param id The unique identifier of the crop.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Get the name of the crop.
   *
   * @return The name of the crop.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of the crop.
   *
   * @param name The name of the crop.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the planted area of the crop in acres.
   *
   * @return The planted area of the crop.
   */
  public Double getPlantedArea() {
    return plantedArea;
  }

  /**
   * Set the planted area of the crop in acres.
   *
   * @param plantedArea The planted area of the crop.
   */
  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  /**
   * Get the farm to which this crop belongs.
   *
   * @return The farm to which this crop belongs.
   */
  public Farm getFarm() {
    return farm;
  }

  /**
   * Set the farm to which this crop belongs.
   *
   * @param farm The farm to which this crop belongs.
   */
  public void setFarm(Farm farm) {
    this.farm = farm;
  }
}
