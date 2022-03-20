package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;

class MessageSenderImplTest {

    @ParameterizedTest
    @ValueSource(strings = {"96.", "96.10.132.11", "96.44.183.149"})
    public void testSendEng(String ip) {

        String expected = "Welcome";
        //arrange
        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry()).thenReturn(Country.USA);

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(Mockito.<String>any())).thenReturn(location);

        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        //act
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
        //assert
        Assertions.assertEquals(expected, messageSender.send(map));
    }
}