package uk.co.certait.waracle.service;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import uk.co.certait.waracle.domain.Cake;
import uk.co.certait.waracle.repository.CakeRepository;

@Component
public class CakeDataImportService {

	@Value("${cake.data.url}")
	private String cakeDataUrl;

	@Autowired
	private RestTemplateBuilder builder;

	@Autowired
	private CakeRepository repository;

	private RestTemplate restTemplate;

	@PostConstruct
	@Transactional
	public void initalizeCakeData() {
		restTemplate = builder.rootUri(cakeDataUrl).build();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
		restTemplate.getMessageConverters().add(converter);

		for (Cake cake : getAllCakes()) {
			repository.save(cake);
		}
	}

	private List<Cake> getAllCakes() {
		return restTemplate.exchange(cakeDataUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Cake>>() {
		}).getBody();
	}
}
