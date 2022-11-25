package com.indusnet.tiny;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse {

    public String domain;
    public String alias;
    public boolean deleted;
    public boolean archived;   
    public String created_at;
    public String expires_at;
    public String tiny_url;
    public String url;
    
        
}