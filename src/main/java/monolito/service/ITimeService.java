package monolito.service;

import monolito.model.Temperatura;

public interface ITimeService {
    Temperatura getByCity(String city);
}
