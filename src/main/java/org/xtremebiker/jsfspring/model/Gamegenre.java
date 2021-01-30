package org.xtremebiker.jsfspring.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "games_genres")
@Entity
@Data
public class Gamegenre implements Serializable {

private static final long serialVersionUID=1L;

@Id
@Column(name = "id", nullable = false)
private Long id;

@Column(name = "game_id")
private Long game_id;

@Column(name = "genre_id")
private Long genre_id;

        }
