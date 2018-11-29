package io.eroshenkoam.swagger;

import org.openapitools.example.api.PetsApi;
import retrofit2.Retrofit;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class GeneratedClientUsage {

    public static void main(String[] args) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://...")
                .build();

        final PetsApi petsApi = retrofit.create(PetsApi.class);
    }

}
