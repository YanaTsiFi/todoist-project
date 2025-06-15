package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateRequest {
    private String name;
    private String content;
    @JsonProperty("project_id")
    private String projectId;
    private String id;
    private String dueString;
}