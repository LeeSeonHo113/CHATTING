package site.metacoding.data01;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ItemModeling {

    private String 주소;
    private String 운영시작일자;
    private String 구분코드;
    private String RAT가능여부;
    private String 요양종별코드;
    // private String 호흡기전담클리닉여부;
    private String 시군구명;
    private String 시도명;
    private String 전화번호;
    // private String X좌표;
    private String 세계x좌표;
    // private String Y좌표;
    // private String 세계y좌표;
    private String 요양기관명;
    private String 암호화된요양기호;
}