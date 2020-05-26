package com.esme.Music.infrastructure;

//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.List;
//
//@Getter
//@ToString
//@EqualsAndHashCode
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//
//public class LabelEntity {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//    @Column(name = "Name", length=50, nullable = false)
//    private String name_label;
//    @Column(name = "Location")
//    private String location;
//    @Column(name = "Fundation Date")
//    private LocalDate fundation_date;
//
//    @OneToMany(mappedBy = "labelEntity", cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER)
//    private List<ArtistEntity> artistEntities;
//}
