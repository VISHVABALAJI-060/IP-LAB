<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
    <head>
      <title>Product Information</title>
      <style>
        table {
          border-collapse: collapse;
          width: 100%;
        }
        th, td {
          border: 1px solid black;
          padding: 8px;
          text-align: left;
        }
        th {
          background-color: #f2f2f2;
        }
        .highlight {
          background-color: yellow;
        }
      </style>
    </head>
    <body>
      <h2>Product Information</h2>
      <table>
        <tr>
          <th>Name</th>
          <th>Price</th>
        </tr>
        <xsl:for-each select="products/product">
          <tr>
            <td><xsl:value-of select="name"/></td>
            <xsl:variable name="price" select="price"/>
            <xsl:choose>
              <xsl:when test="$price &gt; 50">
                <td class="highlight"><xsl:value-of select="$price"/></td>
              </xsl:when>
              <xsl:otherwise>
                <td><xsl:value-of select="$price"/></td>
              </xsl:otherwise>
            </xsl:choose>
          </tr>
        </xsl:for-each>
      </table>
    </body>
  </html>
</xsl:template>

</xsl:stylesheet>  



