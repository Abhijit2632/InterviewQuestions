package com.cosmos.webfluxtutorial.util;

import com.cosmos.webfluxtutorial.pojo.NSEExcelData;
import com.cosmos.webfluxtutorial.pojo.NSEExcelDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RangeNseData {
    String url = "https://script.google.com/macros/s/AKfycbwbizsypFtE4TsMFsbiU5Idxoup5ASx8qxH-kszD900lv2MFdKjE_GO-5mE7f22lMFm/exec";
    @Autowired
    private RestTemplate restTemplate;

    private NSEExcelDatas readAllData(){
        NSEExcelDatas nseExcelDatas = restTemplate.getForObject(url,NSEExcelDatas.class);
        return nseExcelDatas;
    }

    public Flux<List<NSEExcelData>> getDataBellowTen(){
        NSEExcelDatas nseExcelDatas = readAllData();
        List<NSEExcelData> dataUnder10 = nseExcelDatas.getNseExcelDataList().stream()
                .filter(s->{
                    Float ltp = 0f;
                    try{
                        ltp = Float.parseFloat(s.getCompanyLTP());
                    }catch (Exception e){
                        System.out.println("Remove this : "+s);
                    }

                    return ltp<10f;
                })
                .collect(Collectors.toList());
        Flux<List<NSEExcelData>> data = Flux.just(dataUnder10);
        return data;
    }
    public Flux<List<NSEExcelData>> getDataBetweenTenAndThirty(){
        NSEExcelDatas nseExcelDatas = readAllData();
        List<NSEExcelData> dataUnder10 = nseExcelDatas.getNseExcelDataList().stream()
                .filter(s->{
                    Float ltp = 0f;
                    try{
                        ltp = Float.parseFloat(s.getCompanyLTP());
                    }catch (Exception e){
                        System.out.println("Remove this : "+s);
                    }
                    return ltp>10f && ltp <30f;
                })
                .collect(Collectors.toList());
        Flux<List<NSEExcelData>> data = Flux.just(dataUnder10);
        return data;
    }
    public Flux<List<NSEExcelData>> getDataBetweenThirtyAndFifty(){
        NSEExcelDatas nseExcelDatas = readAllData();
        List<NSEExcelData> dataUnder10 = nseExcelDatas.getNseExcelDataList().stream()
                .filter(s->{
                    Float ltp = 0f;
                    try{
                        ltp = Float.parseFloat(s.getCompanyLTP());
                    }catch (Exception e){
                        System.out.println("Remove this : "+s);
                    }
                    return ltp>30f && ltp <50f;
                })
                .collect(Collectors.toList());
        Flux<List<NSEExcelData>> data = Flux.just(dataUnder10);
        return data;
    }
    public Flux<List<NSEExcelData>> getDataBetweenFiftyAndHundred(){
        NSEExcelDatas nseExcelDatas = readAllData();
        List<NSEExcelData> dataUnder10 = nseExcelDatas.getNseExcelDataList().stream()
                .filter(s->{
                    Float ltp = 0f;
                    try{
                        ltp = Float.parseFloat(s.getCompanyLTP());
                    }catch (Exception e){
                        System.out.println("Remove this : "+s);
                    }
                    return ltp>50f && ltp <100f;
                })
                .collect(Collectors.toList());
        Flux<List<NSEExcelData>> data = Flux.just(dataUnder10);
        return data;
    }
    public Flux<List<NSEExcelData>> getDataBetweenHundredAndThreeHundred(){
        NSEExcelDatas nseExcelDatas = readAllData();
        List<NSEExcelData> dataUnder10 = nseExcelDatas.getNseExcelDataList().stream()
                .filter(s->{
                    Float ltp = 0f;
                    try{
                        ltp = Float.parseFloat(s.getCompanyLTP());
                    }catch (Exception e){
                        System.out.println("Remove this : "+s);
                    }
                    return ltp>100f && ltp <300f;
                })
                .collect(Collectors.toList());
        Flux<List<NSEExcelData>> data = Flux.just(dataUnder10);
        return data;
    }
    public Flux<List<NSEExcelData>> getDataBetweenRange(Float startValue,Float endValue){
        NSEExcelDatas nseExcelDatas = readAllData();
        List<NSEExcelData> dataUnder10 = nseExcelDatas.getNseExcelDataList().stream()
                .filter(s->{
                    Float ltp = 0f;
                    try{
                        ltp = Float.parseFloat(s.getCompanyLTP());
                    }catch (Exception e){
                        System.out.println("Remove this : "+s);
                    }
                    return ltp>startValue && ltp <endValue;
                })
                .collect(Collectors.toList());
        Flux<List<NSEExcelData>> data = Flux.just(dataUnder10);
        return data;
    }

}
