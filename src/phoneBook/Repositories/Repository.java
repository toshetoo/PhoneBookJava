package phoneBook.Repositories;

import java.util.List;

import phoneBook.Entities.BaseEntity;

public interface Repository<T extends BaseEntity> {
	//private T t;
	
	
	List<T> getAll();
	T getByID(int id);
	void Insert(T item);
	void Update(T item);
	void Delete(T item);
	void Save(T item);
}
