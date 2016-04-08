package phoneBook.Repositories;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository<T> {
	private T t;
	
	
	public List<T> getAll(){
		return new ArrayList<T>();
	}
	public T GetByID(int id){		
		
		return null;
	}
	public void Insert(T item){
		
	}
	public void Update(T item){
		
	}
	public void Delete(T item){
	
	}
}
