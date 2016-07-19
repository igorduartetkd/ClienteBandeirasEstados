package com.webService;

public class TransmissorDeImagemServiceProxy implements com.webService.TransmissorDeImagemService {
  private String _endpoint = null;
  private com.webService.TransmissorDeImagemService transmissorDeImagemService = null;
  
  public TransmissorDeImagemServiceProxy() {
    _initTransmissorDeImagemServiceProxy();
  }
  
  public TransmissorDeImagemServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initTransmissorDeImagemServiceProxy();
  }
  
  private void _initTransmissorDeImagemServiceProxy() {
    try {
      transmissorDeImagemService = (new com.webService.TransmissorDeImagemServiceServiceLocator()).getTransmissorDeImagemServicePort();
      if (transmissorDeImagemService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)transmissorDeImagemService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)transmissorDeImagemService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (transmissorDeImagemService != null)
      ((javax.xml.rpc.Stub)transmissorDeImagemService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.webService.TransmissorDeImagemService getTransmissorDeImagemService() {
    if (transmissorDeImagemService == null)
      _initTransmissorDeImagemServiceProxy();
    return transmissorDeImagemService;
  }
  
  public java.lang.String[] getListaDeEstados() throws java.rmi.RemoteException{
    if (transmissorDeImagemService == null)
      _initTransmissorDeImagemServiceProxy();
    return transmissorDeImagemService.getListaDeEstados();
  }
  
  public byte[] getBandeiraDoEstado(java.lang.String arg0) throws java.rmi.RemoteException{
    if (transmissorDeImagemService == null)
      _initTransmissorDeImagemServiceProxy();
    return transmissorDeImagemService.getBandeiraDoEstado(arg0);
  }
  
  
}