package com.sun.demo.sys.entity;

import com.sun.demo.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by me on 2018/1/4.
 */
@Getter
@Setter
@Table(name="SYS_TWO_COLOUR")
public class TwoColourEntity extends BaseEntity{

    @Column(name = "ID")
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "A")
    private Integer a;

    @Column(name = "B")
    private Integer b;

    @Column(name = "C")
    private Integer c;

    @Column(name = "D")
    private Integer d;

    @Column(name = "E")
    private Integer e;

    @Column(name = "F")
    private Integer f;

    @Column(name = "BLUE")
    private Integer blue;

    @Column(name = "CUMULATIVE")
    private Double cumulative;

    @Column(name = "ONE_NUM")
    private Integer oneNum;

    @Column(name = "ONE_MONEY")
    private Double oneMoney;

    @Column(name = "TWO_NUM")
    private Integer twoNum;

    @Column(name = "TWO_MONEY")
    private Double twoMoney;

    @Column(name = "TOTAL_MONEY")
    private Double totalMoney;

    @Column(name = "TIME")
    private Date time;


}
