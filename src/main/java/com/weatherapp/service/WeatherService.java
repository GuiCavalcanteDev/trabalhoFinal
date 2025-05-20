package com.weatherapp.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.weatherapp.model.CidadeModel;
import com.weatherapp.model.ConsultaClima;
import com.weatherapp.repository.CidadeRepository;
import com.weatherapp.repository.ConsultaClimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class WeatherService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ConsultaClimaRepository consultaClimaRepository;

    private final String API_KEY = "ccd78f85604bf9a732720c42eeda66b0";
    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    private final RestTemplate restTemplate = new RestTemplate();

    public ConsultaClima buscarClimaPorCidade(String cidadeNome) {
        // Formatar a URL com os parâmetros
        String url = BASE_URL + "weather?q=" + cidadeNome + "&appid=" + API_KEY + "&lang=pt_br&units=metric";

        // Chamada para a API externa
        JsonNode response = restTemplate.getForObject(url, JsonNode.class);

        if (response == null) {
            throw new RuntimeException("Erro ao obter dados da API");
        }

        // Obter os dados do clima da resposta
        CidadeModel cidade = new CidadeModel();
        cidade.setNome(response.get("name").asText());
        cidade.setPais(response.get("sys").get("country").asText());

        cidadeRepository.save(cidade); // Salvar a cidade no banco de dados

        // Criar o objeto de ConsultaClima
        ConsultaClima consultaClima = new ConsultaClima();
        consultaClima.setTemperatura(response.get("main").get("temp").asDouble());
        consultaClima.setDescricao(response.get("weather").get(0).get("description").asText());
        consultaClima.setDataConsulta(LocalDateTime.now());
        consultaClima.setLatitude(response.get("coord").get("lat").asText());
        consultaClima.setLongitude(response.get("coord").get("lon").asText());
        consultaClima.setTemperaturaMin(response.get("main").get("temp_min").asText());
        consultaClima.setTemperaturaMax(response.get("main").get("temp_max").asText());
        consultaClima.setUmidade(response.get("main").get("humidity").asText());
        consultaClima.setCidade(cidade);

        String URL_IMAGE = "https://openweathermap.org/img/wn/" + response.get("weather").get(0).get("icon").asText() + "@2x.png";

        consultaClima.setImage(URL_IMAGE);

        consultaClimaRepository.save(consultaClima); // Salvar a consulta no banco

        return consultaClima; // Retornar os dados do clima
    }

    public ConsultaClima buscarPorLatitudeLogitude(String latitude, String longitude){
        String url = BASE_URL + "weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY + "&lang=pt_br&units=metric";

        JsonNode response = restTemplate.getForObject(url, JsonNode.class);

        if (response == null) {
            throw new RuntimeException("Erro ao obter dados da API");
        }

        CidadeModel cidade = new CidadeModel();
        cidade.setNome(response.get("name").asText());
        cidade.setPais(response.get("sys").get("country").asText());

        cidadeRepository.save(cidade);

        ConsultaClima consultaClima = new ConsultaClima();
        consultaClima.setTemperatura(response.get("main").get("temp").asDouble());
        consultaClima.setDescricao(response.get("weather").get(0).get("description").asText());
        consultaClima.setDataConsulta(LocalDateTime.now());
        consultaClima.setLatitude(response.get("coord").get("lat").asText());
        consultaClima.setLongitude(response.get("coord").get("lon").asText());
        consultaClima.setTemperaturaMin(response.get("main").get("temp_min").asText());
        consultaClima.setTemperaturaMax(response.get("main").get("temp_max").asText());
        consultaClima.setUmidade(response.get("main").get("humidity").asText());
        consultaClima.setCidade(cidade);

        String URL_IMAGE = "https://openweathermap.org/img/wn/" + response.get("weather").get(0).get("icon").asText() + "@2x.png";

        consultaClima.setImage(URL_IMAGE);

        consultaClimaRepository.save(consultaClima);

        String url5days = BASE_URL + "forecast?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY + "&lang=pt_br&units=metric";

        JsonNode response5days = restTemplate.getForObject(url, JsonNode.class);

        if (response == null) {
            throw new RuntimeException("Erro ao obter dados da API");
        }



        return consultaClima;
    }
}
