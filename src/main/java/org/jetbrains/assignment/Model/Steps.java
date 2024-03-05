package org.jetbrains.assignment.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Steps {
    private int x;
    private int y;
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @Builder.Default
    private Long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

    public Steps(int i, int stepsCount) {
    }
}
