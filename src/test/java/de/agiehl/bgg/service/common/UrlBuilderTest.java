package de.agiehl.bgg.service.common;

import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class UrlBuilderTest {

    private final UrlBuilder classUnderTest = UrlBuilder.getInstance();

    private final String BASE_URL = "https://boardgamegeek.com/";

    @Test
    public void shouldBuildQueryStringCorrect() {
        Map<String, Object> queryParameter = new HashMap<>();
        queryParameter.put("test1", "value1");
        queryParameter.put("test2", "value2");

        String url = classUnderTest.createUrl(BASE_URL, queryParameter);
        assertThat(url).isEqualTo(BASE_URL + "?test2=value2&test1=value1");
    }

    @Test
    public void shouldIgnoreNullValues() {
        Map<String, Object> queryParameter = new HashMap<>();
        queryParameter.put("test", null);

        String url = classUnderTest.createUrl(BASE_URL, queryParameter);
        assertThat(url).isEqualTo(BASE_URL);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void shouldMapBooleanTrue(boolean boolValue) {
        Map<String, Object> queryParameter = new HashMap<>();
        queryParameter.put("test", boolValue);

        String url = classUnderTest.createUrl(BASE_URL, queryParameter);
        if (boolValue) {
            assertThat(url).isEqualTo(BASE_URL + "?test=1");
        } else {
            assertThat(url).isEqualTo(BASE_URL + "?test=0");
        }
    }

    @Test
    public void shouldMapCollection() {
        List<String> listOfStrings = Arrays.asList("1", "2", "3");

        Map<String, Object> queryParameter = new HashMap<>();
        queryParameter.put("test", listOfStrings);

        String url = classUnderTest.createUrl(BASE_URL, queryParameter);
        assertThat(url).isEqualTo(BASE_URL + "?test=" + URLEncoder.encode("1,2,3", StandardCharsets.UTF_8));
    }

    @Test
    public void shouldMapCollectionOfEnum() {
        List<Type> listOfTypes = Collections.singletonList(Type.BOARDGAME);

        Map<String, Object> queryParameter = new HashMap<>();
        queryParameter.put("test", listOfTypes);

        String url = classUnderTest.createUrl(BASE_URL, queryParameter);
        assertThat(url).isEqualTo(BASE_URL + "?test=boardgame");
    }

    @Test
    public void shouldMapEnum() {
        Map<String, Object> queryParameter = new HashMap<>();
        queryParameter.put("test", Type.BOARDGAME);

        String url = classUnderTest.createUrl(BASE_URL, queryParameter);
        assertThat(url).isEqualTo(BASE_URL + "?test=boardgame");
    }

    @Test
    public void shouldMapDateTime() {
        Map<String, Object> queryParameter = new HashMap<>();
        queryParameter.put("test", LocalDateTime.of(2022, Month.MAY, 4, 12, 42, 0));

        String url = classUnderTest.createUrl(BASE_URL, queryParameter);
        assertThat(url).isEqualTo(BASE_URL + "?test=" + URLEncoder.encode("2022-05-04 12:42:00", StandardCharsets.UTF_8));
    }

    @Test
    public void shouldMapDate() {
        Map<String, Object> queryParameter = new HashMap<>();
        queryParameter.put("test", LocalDate.of(2022, Month.MAY, 4));

        String url = classUnderTest.createUrl(BASE_URL, queryParameter);
        assertThat(url).isEqualTo(BASE_URL + "?test=" + URLEncoder.encode("2022-05-04", StandardCharsets.UTF_8));
    }

    @Test
    public void shouldMapInteger() {
        Map<String, Object> queryParameter = new HashMap<>();
        queryParameter.put("test", 42);

        String url = classUnderTest.createUrl(BASE_URL, queryParameter);
        assertThat(url).isEqualTo(BASE_URL + "?test=42");
    }

    @Test
    public void shouldGatherAllFields() {
        QueryParameters queryParameters = QueryParameters.builder().test1("42").testWithCamelCase("21").build();

        String url = classUnderTest.createUrlFromObject(BASE_URL, queryParameters);
        assertThat(url).isEqualTo(BASE_URL + "?testwithcamelcase=21&test1=42");
    }

    @Data
    @Builder
    public static class QueryParameters {
        private String test1;

        private String testWithCamelCase;
    }

}