## Examen Unidad 1 ##





### XSD ###

#### Conexion con mi archivo xml ####
```xsd
XML
<elemento xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="Relacion2.xsd"></elemento>

XSD
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"></xs:schema>
```

#### Como hacer atributos tipo ID ####
```xsd
XML
<elemento id="R001"></elemento>

XSD

<xs:element name="nombre elemento">
    <xs:complexType>

        <xs:sequence>
        </xs:sequence>

        <xs:attribute name="id" use="required">
                <xs:simpleType>
                    <xs:restriction base="xs:string">
                            <xs:pattern value="R\d{3}"></xs:pattern>
                    </xs:restriction>
                </xs:simpleType>
        </xs:attribute>
    </xs:complexType>
</xs:element>
```


#### Nombre con la primera en mayuscula y apellido ####
```xsd
XSD

<xs:element name="nombre">
    <xs:simpleType>
        <xs:restriction base="xs:string">
            <xs:pattern
                value="([A-ZÁÉÍÓÚÑ])+([a-záéíóúñ])+ ([A-ZÁÉÍÓÚÑ])+([a-záéíóúñ])*"></xs:pattern>
        </xs:restriction>
    </xs:simpleType>
```


#### DNI ####
```xsd
XSD

<xs:element name="DNI">
    <xs:simpleType>
        <xs:restriction base="xs:string">
            <xs:pattern
                value="\d{8}[A-Z]+"></xs:pattern>
        </xs:restriction>
    </xs:simpleType>
```



#### Como hacer atributos para los elementos ####
```xsd
XML

<habitacion tipo="Doble" numero="202"/>

XSD

<xs:element name="habitacion">
    <xs:complexType>
        <xs:attribute name="tipo" use="required">
            <xs:simpleType>
                <xs:restriction base="xs:string">
                    <xs:enumeration value="Simple"></xs:enumeration>
                    <xs:enumeration value="Doble"></xs:enumeration>

                </xs:restriction>
            </xs:simpleType>
        </xs:attribute>
    </xs:complexType>
</xs:element>
```


#### Restriccion precio mayor que 0 y decimal ####
```xsd
<xs:element name="precioTotal">
    <xs:simpleType>
        <xs:restriction base="xs:decimal">
            <xs:minInclusive value="0"></xs:minInclusive>
        </xs:restriction>
    </xs:simpleType>
</xs:element>


        O


<xs:element name="precio">
    <xs:simpleType>
        <xs:restriction base="xs:decimal">
            <xs:minInclusive value="0"></xs:minInclusive>
            <xs:pattern value="\d+\.\d{2}"></xs:pattern>
        </xs:restriction>
    </xs:simpleType>
</xs:element>
```


#### Olbigar a que tenga un valor entre 2 numeros ####
```xsd
<xs:element name="stock">
    <xs:simpleType>
        <xs:restriction base="xs:integer">
            <xs:minInclusive value="0"></xs:minInclusive>
            <xs:maxInclusive value="1000"></xs:maxInclusive>
        </xs:restriction>
    </xs:simpleType>
</xs:element>
```


#### Numero de telefono ####
```xsd
<xs:element name="telefono">
    <xs:simpleType>
        <xs:restriction base="xs:string">
            <xs:pattern value="\d{3}-\d{3}-\d{3}"></xs:pattern>
        </xs:restriction>
    </xs:simpleType>
</xs:element>
```



#### Email ####

```xsd
<xs:element name="email">
    <xs:simpleType>
        <xs:restriction base="xs:string">
            <xs:pattern value="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}"/>
        </xs:restriction>
    </xs:simpleType>
</xs:element>
```










