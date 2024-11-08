package jaBankClasses;

import java.util.List;

public interface TransferDAO {

	void createTransfer(Transfer id) throws DuplicatedObjectException;

	void deleteTransfer(String id) throws DAOException;

	void updateTransfer(Transfer id);

	//Transfer showTransfer(String id);

	List<Transfer> listAllTransfers();

}
