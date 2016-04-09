package phoneBook.Repositories;

import java.util.List;

import phoneBook.Entities.BaseEntity;

public abstract class BaseRepository<T extends BaseEntity> {
	//private T t;
	
	
	protected abstract List<T> getAll();
	protected abstract T getByID(int id);
	protected abstract void Insert(T item);
	protected abstract void Update(T item);
	protected abstract void Delete(T item);
	protected abstract void Save(T item);
}
