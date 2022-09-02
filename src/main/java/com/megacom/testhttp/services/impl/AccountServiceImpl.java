package com.megacom.testhttp.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.megacom.testhttp.models.*;
import com.megacom.testhttp.repos.*;
import com.megacom.testhttp.services.AccountService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {

    private final AlbumRepo albumRepo;
    private final UsersRepo usersRepo;
    private final AddressRepo addressRepo;
    private final GeoRepo geoRepo;
    private final CompanyRepo companyRepo;

    private ObjectMapper objectMapper = new ObjectMapper();

    public AccountServiceImpl(AlbumRepo albumRepo, UsersRepo usersRepo, AddressRepo addressRepo, GeoRepo geoRepo, CompanyRepo companyRepo) {
        this.albumRepo = albumRepo;
        this.usersRepo = usersRepo;
        this.addressRepo = addressRepo;
        this.geoRepo = geoRepo;
        this.companyRepo = companyRepo;
    }

    @Override
    public List<Album> test() {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://jsonplaceholder.typicode.com/albums")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                List<Album> albums = new ArrayList<>(Arrays.asList(objectMapper.readValue(response.body().string(), Album[].class)).subList(0, 100));
                albumRepo.saveAll(albums);
                return albums;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

}
