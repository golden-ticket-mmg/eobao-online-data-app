package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "getstartedinfos")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetStartedInfo {
    @Id
    private String arn;

}
