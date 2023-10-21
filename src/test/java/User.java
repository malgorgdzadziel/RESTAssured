import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public  class User {

    Data data;
    Support support;


    @lombok.Data
    static
    class Data{
        public String id, email, first_name, last_name, avatar;

        public Data(String id, String email, String first_name, String last_name, String avatar) {
            this.id = id;
            this.email = email;
            this.first_name = first_name;
            this.last_name = last_name;
            this.avatar = avatar;
        }

        public Data() {
            this.id = "id";
            this.email = "email";
            this.first_name = "first_name";
            this.last_name = "last_name";
            this.avatar = "avatar";
        }

    }



    class Support{
        @JsonIgnoreProperties
        public String url;
        public String text;

        public Support() {
            this.url = "url";
            this.text = "text";
        }
    }

}