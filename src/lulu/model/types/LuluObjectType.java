package lulu.model.types;

import lulu.util.LuluTypeSystem;

/**
 *
 * @author mdsinalpha
 */
public class LuluObjectType implements LuluType {
    
    private final Integer typeCode;
    private final String tag;
    
    private LuluType superType;
    private boolean defined;
    
    public LuluObjectType(String tag){
        this(tag, new LuluObjectType(LuluTypeSystem.OBJECT_TAG, null));
    }
   
    public LuluObjectType(String tag, LuluType superType){
        typeCode = LuluTypeSystem.getNextObjectTypeCode();
        this.tag = tag;
        this.superType = superType;
        defined = false;
    }
    
    @Override
    public Integer getTypeCode(){
        return typeCode;
    }
    
    @Override
    public Integer getSize(){
        return 4;
    }
   
    public String getTag(){
        return tag;
    }
    
    public void setSuperType(LuluType superType){
        this.superType = superType;
    }
    
    public LuluType getSuperType(){
        return superType;
    }
    
    public void define(){
        defined = true;
    }
    
    @Override
    public boolean isDefined(){
        return defined;
    }
    
    @Override
    public boolean convertable(Object o){
        if(o instanceof LuluObjectType)
            return LuluTypeSystem.convertable(this, (LuluObjectType) o);
        return false;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof LuluObjectType)
            return typeCode.equals(((LuluObjectType) o).getTypeCode());
        return false;
    }
    
    @Override
    public String toString(){
        return "LuluObjectType <"+this.tag+">";
    }
    
}
