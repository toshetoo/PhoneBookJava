package phoneBook.Repositories;

import java.util.ArrayList;
import java.util.List;

import phoneBook.Entities.Phone;

public class PhonesRepository extends BaseRepository<Phone>{

	
	@Override
	public List<Phone> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Phone getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Phone> getByContactID(int id){
		List<Phone> phones = new ArrayList<Phone>();
		
		return phones;
	}

	@Override
	public void Insert(Phone item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(Phone item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(Phone item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void Save(Phone item) {
		// TODO Auto-generated method stub
		
	}

}
