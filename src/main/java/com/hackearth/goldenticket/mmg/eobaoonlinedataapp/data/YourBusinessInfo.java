package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "yourbusinessinfos")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YourBusinessInfo {
    @Id
    private String arn;

}
