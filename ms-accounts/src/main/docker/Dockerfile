FROM openjdk:11-jre-slim

VOLUME /tmp
RUN export DEBIAN_FRONTEND=noninteractive \
    && apt-get update \
    && apt-get install -y --no-install-recommends \
    && apt-get install -y curl \
    && apt-get install -y procps \
    && apt-get install tzdata \
	&& rm -rf /var/lib/apt/lists/*; \
	echo America/Lima > /etc/timezone; \
    rm /etc/localtime; \
	dpkg-reconfigure -fnoninteractive tzdata

ADD target/ms-accounts-*.jar app.jar
ADD src/main/docker/entrypoint.sh entrypoint.sh
RUN chmod +x entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]