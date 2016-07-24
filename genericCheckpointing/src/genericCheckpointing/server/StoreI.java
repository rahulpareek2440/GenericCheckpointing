/**
 * Here code for StoreI which is extending StoreRestoreI interface
 * 
 *  
 */
package genericCheckpointing.server;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

public interface StoreI extends StoreRestoreI {
    void writeObj(MyAllTypesFirst aRecord, String wireFormat);
    void writeObj(MyAllTypesSecond aRecord, String wireFormat);
}