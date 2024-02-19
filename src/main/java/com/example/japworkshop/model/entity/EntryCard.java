package com.example.japworkshop.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class EntryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private UUID uuid;

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @ManyToMany
    @JoinTable(name = "floor_access", joinColumns = @JoinColumn(name = "entry_card_id"), inverseJoinColumns = @JoinColumn(name = "floor_id"))
    private Set<Floor> floorAccess;

    @Override
    public String toString() {
        return "EntryCard{" +
                "id=" + id +
                ", uuid=" + uuid +
                '}';
    }

    public void setFloorAccess(Set<Floor> floorAccess) {
        this.floorAccess = floorAccess;
    }
}
