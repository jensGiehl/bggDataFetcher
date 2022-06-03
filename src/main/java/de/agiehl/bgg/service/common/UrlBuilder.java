package de.agiehl.bgg.service.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Log
public class UrlBuilder {

    private static UrlBuilder instance;

    public String createUrlFromObject(String url, Object queryParameters) {
        Map<String, Object> queryParametersMap = new HashMap<>();

        Arrays.stream(queryParameters.getClass().getDeclaredFields())
                .sequential()
                .forEach(field -> {
                    try {
                        field.setAccessible(true);
                        String key = field.getName().toLowerCase();
                        Object value = field.get(queryParameters);
                        queryParametersMap.put(key, value);
                    } catch (IllegalAccessException e) {
                        String msg = String.format("Couldn't access value of field '%s' on class %s", field.getName(), queryParameters.getClass().getName());
                        log.log(Level.WARNING, msg, e);
                    }
                });

        return createUrl(url, queryParametersMap);
    }

    public String createUrl(String url, Map<String, Object> queryParameters) {
        StringBuilder stringBuilder = new StringBuilder(url);
        boolean isFirstParameter = true;

        for (String key : queryParameters.keySet()) {
            Optional<String> value = getValue(queryParameters.get(key));
            if (value.isPresent()) {
                if (isFirstParameter) {
                    isFirstParameter = false;
                    stringBuilder.append("?");
                } else {
                    stringBuilder.append("&");
                }

                stringBuilder.append(key)
                        .append("=")
                        .append(URLEncoder.encode(value.get(), StandardCharsets.UTF_8));
            }
        }

        return stringBuilder.toString();
    }

    private Optional<String> getValue(Object value) {
        if (Objects.isNull(value)) {
            return Optional.empty();
        }

        if (value instanceof Boolean) {
            return Optional.of(transformBooleanToString((Boolean) value));
        }

        if (value instanceof Collection<?>) {
            String collectionAsString = ((Collection<?>) value).stream().filter(Objects::nonNull).map(this::mapToString).collect(Collectors.joining(","));
            if (collectionAsString.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(collectionAsString);
        }

        if (value.getClass().isEnum()) {
            return Optional.of(((Enum<?>) value).name().toLowerCase());
        }

        if (value instanceof LocalDateTime) {
            String dateAsString = ((LocalDateTime) value).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return Optional.of(dateAsString);
        }

        if (value instanceof LocalDate) {
            String dateAsString = ((LocalDate) value).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return Optional.of(dateAsString);
        }

        String toString = value.toString();
        if (toString.isBlank()) {
            return Optional.empty();
        }

        return Optional.of(toString);
    }

    private String mapToString(Object value) {
        if (value.getClass().isEnum()) {
            return ((Enum<?>) value).name().toLowerCase();
        }

        return value.toString();
    }

    private String transformBooleanToString(Boolean value) {
        return value ? "1" : "0";
    }

    public static UrlBuilder getInstance() {
        if (Objects.isNull(instance)) {
            instance = new UrlBuilder();
        }

        return instance;
    }

}
