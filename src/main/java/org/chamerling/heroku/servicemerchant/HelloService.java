/**
 * 
 */
package org.chamerling.heroku.servicemerchant;

import com.servermerchant.model.*;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author chamerling
 * 
 */
@WebService
public interface HelloService {

	@WebMethod(operationName = "addTransaksi")
        public String addTransaksi(@WebParam(name = "idKartu") String idKartu, @WebParam(name = "nominal") int nominal);
        
        public Boolean addTransaksiBarangJumlah(@WebParam(name = "waktu") String waktu, @WebParam(name = "idBarang") String idBarang, @WebParam(name = "jumlah") String jumlah);
        
        @WebMethod(operationName = "getListTransaksi")
        public ArrayTransaksi getListTransaksi();
        
        @WebMethod(operationName = "getTransaksiBarangByWaktu")
        public ArrayTransaksiBarang getTransaksiBarangByWaktu(@WebParam(name = "waktu")  String waktu);
        
        @WebMethod(operationName = "getListBarang")
        public ArrayBarang getListBarang();
        
        /*@WebMethod(operationName = "getBarang")
        public Barang getBarang(@WebParam(name = "idBarang") String idBarang);*/
        
        /*@WebMethod(operationName = "getTransaksiBarangByIDTransaksi")
        public ArrayList<TransaksiBarang> getTransaksiBarangByIDTransaksi(@WebParam(name = "idBarang") String idTransaksi);*/
}
