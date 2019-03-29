package dz.univbechar.service.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import dz.univbechar.service.entity.Information_contacte;

public interface Info_Contact extends JpaRepository<Information_contacte, Integer>{
//public Information_contacte update(Information_contacte object);
}
