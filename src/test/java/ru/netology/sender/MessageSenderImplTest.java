package ru.netology.sender;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;

class MessageSenderImplTest {

    @BeforeEach
    public void init() {
        System.out.println("test started");
    }

    @BeforeAll
    public static void started() {
        System.out.println("started MessageSenderImplTest");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }

    @ParameterizedTest
    @ValueSource(strings = {"172.", "172.0.32.11", "172.66.22.11"})
    public void testSendRus(String ip) {

        String expected = "Добро пожаловать";
        //arrange
        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry()).thenReturn(Country.RUSSIA);

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(any())).thenReturn(location);

        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        //act
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
        //assert
        Assertions.assertEquals(expected, messageSender.send(headers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"96.", "96.10.132.11", "96.44.183.149"})
    public void testSendEng(String ip) {

        String expected = "Welcome";
        //arrange
        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry()).thenReturn(Country.USA);

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(any())).thenReturn(location);

        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        //act
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
        //assert
        Assertions.assertEquals(expected, messageSender.send(headers));
    }
}