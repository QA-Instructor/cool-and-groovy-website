package com.getyourway.api.services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EventsServiceUnitTest {

    @Test
    void getEventsWithin5km_givenCoordinates_returnsFilteredString() throws IOException {
        //arrange
        double latitude = 51.509865;
        double longitude = -0.118092;

        String mockedResponseBodyString = "{\"count\":5000,\"overflow\":true,\"next\":\"https://api.predicthq.com/v1/events/?limit=10&offset=10&within=5km%4051.509865%2C-0.118092\",\"previous\":null,\"results\":[{\"relevance\":0.0,\"id\":\"DEK6UA8TJvCeNEza5w\",\"title\":\"Metrik Presents Ex Machina 2021\",\"description\":\"\",\"category\":\"festivals\",\"labels\":[\"festival\"],\"rank\":0,\"local_rank\":0,\"aviation_rank\":null,\"phq_attendance\":null,\"entities\":[],\"duration\":172799,\"start\":\"2021-11-19T00:00:00Z\",\"end\":\"2021-11-20T23:59:59Z\",\"updated\":\"2021-08-06T19:06:39Z\",\"first_seen\":\"2021-07-27T03:03:01Z\",\"timezone\":\"Europe/London\",\"location\":[-0.0817228,51.5274499],\"geo\":{\"geometry\":{\"coordinates\":[-0.0817228,51.5274499],\"type\":\"Point\"}},\"scope\":\"locality\",\"country\":\"GB\",\"place_hierarchies\":[[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"3333148\",\"6690594\"],[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"2643743\"]],\"state\":\"active\",\"brand_safe\":true,\"private\":false},{\"relevance\":0.0,\"id\":\"xictA4Zzs9EQKc4wXE\",\"title\":\"Natural History Museum Ice Rink\",\"description\":\"\",\"category\":\"sports\",\"labels\":[\"community\",\"skating\",\"sport\"],\"rank\":0,\"local_rank\":0,\"aviation_rank\":null,\"phq_attendance\":null,\"entities\":[{\"formatted_address\":\"Cromwell Road\\nLondon SW7 5BD\\nUnited Kingdom\",\"entity_id\":\"bW2HaK9vWPt7JuRA4wrkPL\",\"type\":\"venue\",\"name\":\"Natural History Museum\"}],\"duration\":0,\"start\":\"2021-11-18T23:59:00Z\",\"end\":\"2021-11-18T23:59:00Z\",\"updated\":\"2021-07-07T00:35:53Z\",\"first_seen\":\"2021-07-07T00:24:16Z\",\"timezone\":\"Europe/London\",\"location\":[-0.1763672,51.496715],\"geo\":{\"geometry\":{\"coordinates\":[-0.1763672,51.496715],\"type\":\"Point\"}},\"scope\":\"locality\",\"country\":\"GB\",\"place_hierarchies\":[[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"3333218\",\"6690580\"],[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"2643743\"]],\"state\":\"active\",\"brand_safe\":true,\"private\":false},{\"relevance\":0.0,\"id\":\"GPnAcVm2XAWRmKAagF\",\"title\":\"Whiskey Moonface\",\"description\":\"\",\"category\":\"concerts\",\"labels\":[\"concert\",\"music\"],\"rank\":22,\"local_rank\":29,\"aviation_rank\":0,\"phq_attendance\":40,\"entities\":[{\"formatted_address\":\"NW1 7AN\\nUnited Kingdom\",\"entity_id\":\"L6ZWGv9GCwvKDiqU2nGCMT\",\"type\":\"venue\",\"name\":\"Green Note\"}],\"duration\":0,\"start\":\"2021-11-18T20:30:00Z\",\"end\":\"2021-11-18T20:30:00Z\",\"updated\":\"2021-07-18T07:21:10Z\",\"first_seen\":\"2021-07-18T07:20:57Z\",\"timezone\":\"Europe/London\",\"location\":[-0.145864,51.5372186],\"geo\":{\"geometry\":{\"coordinates\":[-0.145864,51.5372186],\"type\":\"Point\"}},\"scope\":\"locality\",\"country\":\"GB\",\"place_hierarchies\":[[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"3333138\",\"3345437\"],[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"2643743\"]],\"state\":\"active\",\"brand_safe\":true,\"private\":false},{\"relevance\":0.0,\"id\":\"85Hwi7yAz3WA9KeGur\",\"title\":\"The Woman In Black\",\"description\":\"\",\"category\":\"performing-arts\",\"labels\":[\"entertainment\",\"performing-arts\"],\"rank\":39,\"local_rank\":46,\"aviation_rank\":0,\"phq_attendance\":277,\"entities\":[{\"formatted_address\":\"Russell St, London WC2B 5HH, UK\\nLondon WC2B 5HH\\nUnited Kingdom\",\"entity_id\":\"yGnTEdNd5UWPFBXKcRwqCW\",\"type\":\"venue\",\"name\":\"Fortune Theatre\"}],\"duration\":0,\"start\":\"2021-11-18T20:00:00Z\",\"end\":\"2021-11-18T20:00:00Z\",\"updated\":\"2021-07-17T04:47:53Z\",\"first_seen\":\"2021-05-16T00:05:06Z\",\"timezone\":\"Europe/London\",\"location\":[-0.1206635,51.5132654],\"geo\":{\"geometry\":{\"coordinates\":[-0.1206635,51.5132654],\"type\":\"Point\"}},\"scope\":\"locality\",\"country\":\"GB\",\"place_hierarchies\":[[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"3333138\",\"2646781\"],[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"2643743\"]],\"state\":\"active\",\"brand_safe\":true,\"private\":false},{\"relevance\":0.0,\"id\":\"9m8kJhEg2DNZPKFR44\",\"title\":\"Alex Lipinski\",\"description\":\"\",\"category\":\"community\",\"labels\":[\"concert\",\"music\"],\"rank\":34,\"local_rank\":40,\"aviation_rank\":null,\"phq_attendance\":150,\"entities\":[{\"formatted_address\":\"34-35 Great Sutton Street\\nLondon EC1V 0DX\\nUnited Kingdom\",\"entity_id\":\"6Xc9ivYMeksqk5TWw2miJ9\",\"type\":\"venue\",\"name\":\"The Slaughtered Lamb\"}],\"duration\":0,\"start\":\"2021-11-18T20:00:00Z\",\"end\":\"2021-11-18T20:00:00Z\",\"updated\":\"2021-10-15T00:51:55Z\",\"first_seen\":\"2021-10-15T00:14:13Z\",\"timezone\":\"Europe/London\",\"location\":[-0.1011902,51.5233004],\"geo\":{\"geometry\":{\"coordinates\":[-0.1011902,51.5233004],\"type\":\"Point\"}},\"scope\":\"locality\",\"country\":\"GB\",\"place_hierarchies\":[[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"3333156\",\"6690573\"],[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"2643743\"]],\"state\":\"active\",\"brand_safe\":true,\"private\":false},{\"relevance\":0.0,\"id\":\"FcbFzHrE4Gt9nnGfuH\",\"title\":\"Thursday Stand Up Comedy Club\",\"description\":\"Comedy Carnival features award-winning international comedians from around the world, every Thursday, Friday and Saturday night.\",\"category\":\"performing-arts\",\"labels\":[\"concert\",\"music\",\"performing-arts\"],\"rank\":0,\"local_rank\":0,\"aviation_rank\":null,\"phq_attendance\":null,\"entities\":[],\"duration\":7200,\"start\":\"2021-11-18T20:00:00Z\",\"end\":\"2021-11-18T22:00:00Z\",\"updated\":\"2021-09-16T02:19:39Z\",\"first_seen\":\"2021-09-01T04:22:25Z\",\"timezone\":\"Europe/London\",\"location\":[-0.13317430000006425,51.5111877],\"geo\":{\"geometry\":{\"coordinates\":[-0.13317430000006425,51.5111877],\"type\":\"Point\"}},\"scope\":\"locality\",\"country\":\"GB\",\"place_hierarchies\":[[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"2643743\"]],\"state\":\"active\",\"brand_safe\":true,\"private\":false},{\"relevance\":0.0,\"id\":\"JoH92tD2h7uVVoAk77\",\"title\":\"Four Quartets\",\"description\":\"\",\"category\":\"performing-arts\",\"labels\":[\"entertainment\",\"performing-arts\"],\"rank\":44,\"local_rank\":51,\"aviation_rank\":0,\"phq_attendance\":480,\"entities\":[{\"formatted_address\":\"Panton Street\\nSW1Y 4DN\\nUnited Kingdom\",\"entity_id\":\"LH8ivRfSR2DKxkp7QH7g29\",\"type\":\"venue\",\"name\":\"Harold Pinter Theatre\"}],\"duration\":0,\"start\":\"2021-11-18T20:00:00Z\",\"end\":\"2021-11-18T20:00:00Z\",\"updated\":\"2021-07-02T00:22:49Z\",\"first_seen\":\"2021-07-02T00:15:09Z\",\"timezone\":\"Europe/London\",\"location\":[-0.1316775,51.50931],\"geo\":{\"geometry\":{\"coordinates\":[-0.1316775,51.50931],\"type\":\"Point\"}},\"scope\":\"locality\",\"country\":\"GB\",\"place_hierarchies\":[[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"2643743\"]],\"state\":\"active\",\"brand_safe\":true,\"private\":false},{\"relevance\":0.0,\"id\":\"k9WV9CpyqULNSgT8AD\",\"title\":\"Keiyaa\",\"description\":\"\",\"category\":\"community\",\"labels\":[\"concert\",\"music\"],\"rank\":36,\"local_rank\":41,\"aviation_rank\":null,\"phq_attendance\":200,\"entities\":[{\"formatted_address\":\"7 Torrens Street\\nLondon EC1V 1NQ\\nUnited Kingdom\",\"entity_id\":\"CZciXgeeEQm4WKA3RuRWjC\",\"type\":\"venue\",\"name\":\"Electrowerkz\"}],\"duration\":0,\"start\":\"2021-11-18T20:00:00Z\",\"end\":\"2021-11-18T20:00:00Z\",\"updated\":\"2021-06-10T00:53:24Z\",\"first_seen\":\"2021-06-10T00:25:28Z\",\"timezone\":\"Europe/London\",\"location\":[-0.105002,51.532518],\"geo\":{\"geometry\":{\"coordinates\":[-0.105002,51.532518],\"type\":\"Point\"}},\"scope\":\"locality\",\"country\":\"GB\",\"place_hierarchies\":[[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"3333156\",\"2646003\"],[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"2643743\"]],\"state\":\"active\",\"brand_safe\":true,\"private\":false},{\"relevance\":0.0,\"id\":\"6W7HW7s6QbALTc5WBb\",\"title\":\"Come From Away\",\"description\":\"\",\"category\":\"performing-arts\",\"labels\":[\"entertainment\",\"music\",\"performing-arts\"],\"rank\":0,\"local_rank\":0,\"aviation_rank\":null,\"phq_attendance\":null,\"entities\":[{\"formatted_address\":\"110 Charing Cross Road\\nLondon WC2H 0JP\\nUnited Kingdom\",\"entity_id\":\"sEKCfmhY5YrpGFNN3Junca\",\"type\":\"venue\",\"name\":\"Phoenix Theatre\"}],\"duration\":0,\"start\":\"2021-11-18T19:30:00Z\",\"end\":\"2021-11-18T19:30:00Z\",\"updated\":\"2020-12-15T02:04:57Z\",\"first_seen\":\"2020-12-15T00:28:53Z\",\"timezone\":\"Europe/London\",\"location\":[-0.1295213,51.5144665],\"geo\":{\"geometry\":{\"coordinates\":[-0.1295213,51.5144665],\"type\":\"Point\"}},\"scope\":\"locality\",\"country\":\"GB\",\"place_hierarchies\":[[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"2643743\"]],\"state\":\"active\",\"brand_safe\":true,\"private\":false},{\"relevance\":0.0,\"id\":\"6uEbgLrQzzz5z4eq3C\",\"title\":\"Pride and Prejudice* (*sort of)\",\"description\":\"\",\"category\":\"performing-arts\",\"labels\":[\"comedy\",\"entertainment\",\"performing-arts\"],\"rank\":41,\"local_rank\":48,\"aviation_rank\":0,\"phq_attendance\":355,\"entities\":[{\"formatted_address\":\"218-223 Piccadilly\\nW1V 9LB\\nUnited Kingdom\",\"entity_id\":\"WKJsSRBXRhc2SUfLdq7jXj\",\"type\":\"venue\",\"name\":\"Criterion Theatre\"}],\"duration\":0,\"start\":\"2021-11-18T19:30:00Z\",\"end\":\"2021-11-18T19:30:00Z\",\"updated\":\"2021-09-12T00:16:27Z\",\"first_seen\":\"2021-09-12T00:12:11Z\",\"timezone\":\"Europe/London\",\"location\":[-0.1343267,51.5097608],\"geo\":{\"geometry\":{\"coordinates\":[-0.1343267,51.5097608],\"type\":\"Point\"}},\"scope\":\"locality\",\"country\":\"GB\",\"place_hierarchies\":[[\"6295630\",\"6255148\",\"2635167\",\"6269131\",\"2648110\",\"2643743\"]],\"state\":\"active\",\"brand_safe\":true,\"private\":false}]}";
        String expected = "{\"events\":[{\"title\":\"Metrik Presents Ex Machina 2021\",\"description\":\"\",\"category\":\"festivals\",\"start_date\":\"19-11-21 00:00:00\",\"end_date\":\"20-11-21 23:59:59\",\"location_of_event\":[-0.0817228,51.5274499],\"distance_from_location\":\"3.187km\",\"labels\":[\"festival\"]},{\"title\":\"Natural History Museum Ice Rink\",\"description\":\"\",\"category\":\"sports\",\"start_date\":\"18-11-21 23:59:00\",\"end_date\":\"18-11-21 23:59:00\",\"location_of_event\":[-0.1763672,51.496715],\"distance_from_location\":\"4.290km\",\"labels\":[\"community\",\"skating\",\"sport\"]},{\"title\":\"Whiskey Moonface\",\"description\":\"\",\"category\":\"concerts\",\"start_date\":\"18-11-21 20:30:00\",\"end_date\":\"18-11-21 20:30:00\",\"location_of_event\":[-0.145864,51.5372186],\"distance_from_location\":\"3.597km\",\"labels\":[\"concert\",\"music\"]},{\"title\":\"The Woman In Black\",\"description\":\"\",\"category\":\"performing-arts\",\"start_date\":\"18-11-21 20:00:00\",\"end_date\":\"18-11-21 20:00:00\",\"location_of_event\":[-0.1206635,51.5132654],\"distance_from_location\":\"0.418km\",\"labels\":[\"entertainment\",\"performing-arts\"]},{\"title\":\"Alex Lipinski\",\"description\":\"\",\"category\":\"community\",\"start_date\":\"18-11-21 20:00:00\",\"end_date\":\"18-11-21 20:00:00\",\"location_of_event\":[-0.1011902,51.5233004],\"distance_from_location\":\"1.897km\",\"labels\":[\"concert\",\"music\"]},{\"title\":\"Thursday Stand Up Comedy Club\",\"description\":\"Comedy Carnival features award-winning international comedians from around the world, every Thursday, Friday and Saturday night.\",\"category\":\"performing-arts\",\"start_date\":\"18-11-21 20:00:00\",\"end_date\":\"18-11-21 22:00:00\",\"location_of_event\":[-0.13317430000006425,51.5111877],\"distance_from_location\":\"1.054km\",\"labels\":[\"concert\",\"music\",\"performing-arts\"]},{\"title\":\"Four Quartets\",\"description\":\"\",\"category\":\"performing-arts\",\"start_date\":\"18-11-21 20:00:00\",\"end_date\":\"18-11-21 20:00:00\",\"location_of_event\":[-0.1316775,51.50931],\"distance_from_location\":\"0.942km\",\"labels\":[\"entertainment\",\"performing-arts\"]},{\"title\":\"Keiyaa\",\"description\":\"\",\"category\":\"community\",\"start_date\":\"18-11-21 20:00:00\",\"end_date\":\"18-11-21 20:00:00\",\"location_of_event\":[-0.105002,51.532518],\"distance_from_location\":\"2.677km\",\"labels\":[\"concert\",\"music\"]},{\"title\":\"Come From Away\",\"description\":\"\",\"category\":\"performing-arts\",\"start_date\":\"18-11-21 19:30:00\",\"end_date\":\"18-11-21 19:30:00\",\"location_of_event\":[-0.1295213,51.5144665],\"distance_from_location\":\"0.942km\",\"labels\":[\"entertainment\",\"music\",\"performing-arts\"]},{\"title\":\"Pride and Prejudice* (*sort of)\",\"description\":\"\",\"category\":\"performing-arts\",\"start_date\":\"18-11-21 19:30:00\",\"end_date\":\"18-11-21 19:30:00\",\"location_of_event\":[-0.1343267,51.5097608],\"distance_from_location\":\"1.124km\",\"labels\":[\"comedy\",\"entertainment\",\"performing-arts\"]}]}"; //parseExpectedJsonFile

        EventsService eventsService = spy(new EventsService());

        JsonObject mockedUnfilteredJsonObject = new Gson().fromJson(mockedResponseBodyString, JsonElement.class).getAsJsonObject();
        when(eventsService.fetchEventsList(latitude, longitude)).thenReturn(mockedUnfilteredJsonObject);

        //act
        String actual = eventsService.getEventsWithin5km(latitude, longitude);

        //assert
        assertEquals(expected, actual);
    }
}