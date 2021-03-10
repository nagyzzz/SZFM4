package app.service;

import app.entity.Hallgato;
import app.entity.User;
import app.repository.HallgatoRepository;
import app.repository.UserRepository;

public class HallgatoService {
    private final HallgatoRepository hallgatoRepository;

    public HallgatoService(HallgatoRepository hallgatoRepository) {
        this.hallgatoRepository = hallgatoRepository;
    }

    public void saveHallgato(Hallgato hallgato) {
        hallgatoRepository.save(hallgato);
    }

}
