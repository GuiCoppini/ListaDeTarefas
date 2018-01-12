package EstudandoJS.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class ChangeStatusRequest {
    public String getStatus() {
        return status;
    }

    @NotNull
    @JsonProperty("status")
    String status;
}
