package com.example.sb.configurationproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

/**
 * @author zkzong
 * @date 2017/12/15
 */
@ConfigurationProperties(prefix = "prefix")
@Component
@Data
public class SampleProperty {

    private String stringProp1;
    private String stringProp2;
    @Max(99)
    @Min(0)
    private Integer intProp1;
    private List<String> listProp;
    private Map<String, String> mapProp;

}
