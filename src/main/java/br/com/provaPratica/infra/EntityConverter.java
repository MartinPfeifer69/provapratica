package br.com.provaPratica.infra;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("entityConverter")
public class EntityConverter implements Converter{


	  public Object getAsObject(FacesContext ctx, UIComponent component, String value) {  
	        if (value != null) {  
	        	
	            return this.getAttributesFrom(component).get(value);  
	        }  
	        return null;  
	    }  
	  
	    public String getAsString(FacesContext ctx, UIComponent component, Object value) {  
	  
	        if (value != null  
	                && !"".equals(value)) {  
	  
	        	Object entity = (Object) value;  
	  
	            // adiciona item como atributo do componente  
	            this.addAttribute(component, entity);  
	  
	            String codigo = entity.toString();  
	            if (codigo != null) {  
	                return String.valueOf(codigo);  
	            }  
	        }  
	  
	        return (String) value;  
	    }  
	  
	    protected void addAttribute(UIComponent component, Object o) {  
	        String key = o.toString(); // codigo da empresa como chave neste caso  
	        this.getAttributesFrom(component).put(key, o);  
	    }  
	  
	    protected Map<String, Object> getAttributesFrom(UIComponent component) {  
	        return component.getAttributes();  
	    }  
	  
}	

