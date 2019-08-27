package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.service.VisitService;

import java.util.Set;

/**
 * Created by ledio on 8/27/19
 */
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit != null) {
            if (visit.getPet() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null ||
                    visit.getPet().getOwner().getId() == null) {
                throw new RuntimeException("Invalid Visit!!!");
            }
            return super.save(visit);
        } else
            return null;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }
}
