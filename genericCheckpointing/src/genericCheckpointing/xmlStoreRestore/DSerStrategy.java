package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.DeserializableObject;

public interface DSerStrategy {
	Object processInput(DeserializableObject sObject);
}
