#!/bin/bash

if [ ! -f "$1" ] ; then
  echo ""
  echo "limpa_duplicados - Copyright (C) 2009 Gabriel Fernandes"
  echo ""
  echo "Use: $0 /caminho/do/arquivo"
  echo ""
  echo "Parametros:"
  echo "/caminho/do/arquivo = Caminho completo do arquivo;"
  echo ""
  echo "Exemplo: $0 arquivo.txt"
  echo ""
  echo "gabriel@duel.com.br"
  echo ""
  exit 1
fi

# Recebe caminho completo do arquivo para processar
ARQUIVO=$1
ARQUIVO_SAIDA="SAIDA-$ARQUIVO"
ARQUIVO_DUPLICADOS="DUPLICADOS-$ARQUIVO"

# apaga arquivo antigos ja processados
rm -rf "SAIDA-$ARQUIVO" "DUPLICADOS-$ARQUIVO"
# faz backup do arquivo original
#cp "$ARQUIVO" "ORIGINAL-$ARQUIVO"

# Conta quantidade linha para processar
NUM_LINHAS=$(cat $ARQUIVO | wc -l)
let NUM_LINHAS++


# Imprime na saída padrão, somente os campos que não foram possíveis de ser incrementado.
awk '{ if ( !umArrayLinhas[$0]++ ) { print $0 } }' $ARQUIVO > "SAIDA-$ARQUIVO"

# Imprime na saída padrão, somente os campos que foram possíveis de ser incrementado seu valor no array
awk '{ if ( umArrayLinhas[$0]++ ) { print $0 } }' $ARQUIVO > "DUPLICADOS-$ARQUIVO"

# Conta qtd linhas processadas
CONT_LINHAS_DUPLICADAS=$(cat "DUPLICADOS-$ARQUIVO" | wc -l)
CONT_LINHAS_SAIDA=$(cat "SAIDA-$ARQUIVO" | wc -l)

clear
echo "Processado arquivo: $ARQUIVO" > LOG-$ARQUIVO.txt
echo "Registros: $NUM_LINHAS" >> LOG-$ARQUIVO.txt
echo "Normal:$CONT_LINHAS_SAIDA Duplo:$CONT_LINHAS_DUPLICADAS" >> LOG-$ARQUIVO.txt
