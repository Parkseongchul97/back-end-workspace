<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>JjapTube</title>
<link rel="icon"
	href="https://www.youtube.com/s/desktop/ae4ecf92/img/favicon_144x144.png" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script src="https://kit.fontawesome.com/ef885bd654.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="progress-bar-container">
		<div class="progress-bar"></div>
	</div>
	<header>
		<div class="header-start">
			<i class="fa-solid fa-bars"></i> <a href=""><svg
					xmlns="http://www.w3.org/2000/svg" id="yt-logo-updated-svg_yt1"
					class="external-icon" viewBox="0 0 90 20" focusable="false"
					style="pointer-events: none; display: inherit; width: 100%; height: 100%;">
            <svg id="yt-logo-updated_yt1" viewBox="0 0 90 20"
						preserveAspectRatio="xMidYMid meet"
						xmlns="http://www.w3.org/2000/svg">
              <g>
                <path
							d="M27.9727 3.12324C27.6435 1.89323 26.6768 0.926623 25.4468 0.597366C23.2197 2.24288e-07 14.285 0 14.285 0C14.285 0 5.35042 2.24288e-07 3.12323 0.597366C1.89323 0.926623 0.926623 1.89323 0.597366 3.12324C2.24288e-07 5.35042 0 10 0 10C0 10 2.24288e-07 14.6496 0.597366 16.8768C0.926623 18.1068 1.89323 19.0734 3.12323 19.4026C5.35042 20 14.285 20 14.285 20C14.285 20 23.2197 20 25.4468 19.4026C26.6768 19.0734 27.6435 18.1068 27.9727 16.8768C28.5701 14.6496 28.5701 10 28.5701 10C28.5701 10 28.5677 5.35042 27.9727 3.12324Z"
							fill="#FF0000"></path>
                <path
							d="M11.4253 14.2854L18.8477 10.0004L11.4253 5.71533V14.2854Z"
							fill="white"></path>
              </g>
              <g>
                <g id="youtube-paths_yt1">
                  <path
							d="M34.6024 13.0036L31.3945 1.41846H34.1932L35.3174 6.6701C35.6043 7.96361 35.8136 9.06662 35.95 9.97913H36.0323C36.1264 9.32532 36.3381 8.22937 36.665 6.68892L37.8291 1.41846H40.6278L37.3799 13.0036V18.561H34.6001V13.0036H34.6024Z"></path>
                  <path
							d="M41.4697 18.1937C40.9053 17.8127 40.5031 17.22 40.2632 16.4157C40.0257 15.6114 39.9058 14.5437 39.9058 13.2078V11.3898C39.9058 10.0422 40.0422 8.95805 40.315 8.14196C40.5878 7.32588 41.0135 6.72851 41.592 6.35457C42.1706 5.98063 42.9302 5.79248 43.871 5.79248C44.7976 5.79248 45.5384 5.98298 46.0981 6.36398C46.6555 6.74497 47.0647 7.34234 47.3234 8.15137C47.5821 8.96275 47.7115 10.0422 47.7115 11.3898V13.2078C47.7115 14.5437 47.5845 15.6161 47.3329 16.4251C47.0812 17.2365 46.672 17.8292 46.1075 18.2031C45.5431 18.5771 44.7764 18.7652 43.8098 18.7652C42.8126 18.7675 42.0342 18.5747 41.4697 18.1937ZM44.6353 16.2323C44.7905 15.8231 44.8705 15.1575 44.8705 14.2309V10.3292C44.8705 9.43077 44.7929 8.77225 44.6353 8.35833C44.4777 7.94206 44.2026 7.7351 43.8074 7.7351C43.4265 7.7351 43.156 7.94206 43.0008 8.35833C42.8432 8.77461 42.7656 9.43077 42.7656 10.3292V14.2309C42.7656 15.1575 42.8408 15.8254 42.9914 16.2323C43.1419 16.6415 43.4123 16.8461 43.8074 16.8461C44.2026 16.8461 44.4777 16.6415 44.6353 16.2323Z"></path>
                  <path
							d="M56.8154 18.5634H54.6094L54.3648 17.03H54.3037C53.7039 18.1871 52.8055 18.7656 51.6061 18.7656C50.7759 18.7656 50.1621 18.4928 49.767 17.9496C49.3719 17.4039 49.1743 16.5526 49.1743 15.3955V6.03751H51.9942V15.2308C51.9942 15.7906 52.0553 16.188 52.1776 16.4256C52.2999 16.6631 52.5045 16.783 52.7914 16.783C53.036 16.783 53.2712 16.7078 53.497 16.5573C53.7228 16.4067 53.8874 16.2162 53.9979 15.9858V6.03516H56.8154V18.5634Z"></path>
                  <path
							d="M64.4755 3.68758H61.6768V18.5629H58.9181V3.68758H56.1194V1.42041H64.4755V3.68758Z"></path>
                  <path
							d="M71.2768 18.5634H69.0708L68.8262 17.03H68.7651C68.1654 18.1871 67.267 18.7656 66.0675 18.7656C65.2373 18.7656 64.6235 18.4928 64.2284 17.9496C63.8333 17.4039 63.6357 16.5526 63.6357 15.3955V6.03751H66.4556V15.2308C66.4556 15.7906 66.5167 16.188 66.639 16.4256C66.7613 16.6631 66.9659 16.783 67.2529 16.783C67.4974 16.783 67.7326 16.7078 67.9584 16.5573C68.1842 16.4067 68.3488 16.2162 68.4593 15.9858V6.03516H71.2768V18.5634Z"></path>
                  <path
							d="M80.609 8.0387C80.4373 7.24849 80.1621 6.67699 79.7812 6.32186C79.4002 5.96674 78.8757 5.79035 78.2078 5.79035C77.6904 5.79035 77.2059 5.93616 76.7567 6.23014C76.3075 6.52412 75.9594 6.90747 75.7148 7.38489H75.6937V0.785645H72.9773V18.5608H75.3056L75.5925 17.3755H75.6537C75.8724 17.7988 76.1993 18.1304 76.6344 18.3774C77.0695 18.622 77.554 18.7443 78.0855 18.7443C79.038 18.7443 79.7412 18.3045 80.1904 17.4272C80.6396 16.5476 80.8653 15.1765 80.8653 13.3092V11.3266C80.8653 9.92722 80.7783 8.82892 80.609 8.0387ZM78.0243 13.1492C78.0243 14.0617 77.9867 14.7767 77.9114 15.2941C77.8362 15.8115 77.7115 16.1808 77.5328 16.3971C77.3564 16.6158 77.1165 16.724 76.8178 16.724C76.585 16.724 76.371 16.6699 76.1734 16.5594C75.9759 16.4512 75.816 16.2866 75.6937 16.0702V8.96062C75.7877 8.6196 75.9524 8.34209 76.1852 8.12337C76.4157 7.90465 76.6697 7.79646 76.9401 7.79646C77.2271 7.79646 77.4481 7.90935 77.6034 8.13278C77.7609 8.35855 77.8691 8.73485 77.9303 9.26636C77.9914 9.79787 78.022 10.5528 78.022 11.5335V13.1492H78.0243Z"></path>
                  <path
							d="M84.8657 13.8712C84.8657 14.6755 84.8892 15.2776 84.9363 15.6798C84.9833 16.0819 85.0821 16.3736 85.2326 16.5594C85.3831 16.7428 85.6136 16.8345 85.9264 16.8345C86.3474 16.8345 86.639 16.6699 86.7942 16.343C86.9518 16.0161 87.0365 15.4705 87.0506 14.7085L89.4824 14.8519C89.4965 14.9601 89.5035 15.1106 89.5035 15.3011C89.5035 16.4582 89.186 17.3237 88.5534 17.8952C87.9208 18.4667 87.0247 18.7536 85.8676 18.7536C84.4777 18.7536 83.504 18.3185 82.9466 17.446C82.3869 16.5735 82.1094 15.2259 82.1094 13.4008V11.2136C82.1094 9.33452 82.3987 7.96105 82.9772 7.09558C83.5558 6.2301 84.5459 5.79736 85.9499 5.79736C86.9165 5.79736 87.6597 5.97375 88.1771 6.32888C88.6945 6.684 89.059 7.23433 89.2707 7.98457C89.4824 8.7348 89.5882 9.76961 89.5882 11.0913V13.2362H84.8657V13.8712ZM85.2232 7.96811C85.0797 8.14449 84.9857 8.43377 84.9363 8.83593C84.8892 9.2381 84.8657 9.84722 84.8657 10.6657V11.5641H86.9283V10.6657C86.9283 9.86133 86.9001 9.25221 86.846 8.83593C86.7919 8.41966 86.6931 8.12803 86.5496 7.95635C86.4062 7.78702 86.1851 7.7 85.8864 7.7C85.5854 7.70235 85.3643 7.79172 85.2232 7.96811Z"></path>
                </g>
              </g>
            </svg></svg></a>
		</div>
		<div class="header-center">
			<input type="text" placeholder="검색" />
			<button type="button">
				<i class="fa-solid fa-magnifying-glass"></i>
			</button>
		</div>
		<div class="header-end">
			<button type="button">
				<i class="fa-solid fa-user"></i>
			</button>
		</div>
	</header>
	<main>
		<aside>
			<a href=""> <i class="fa-solid fa-house"></i> <span>홈</span>
			</a> <a href=""> <i class="fa-solid fa-folder"></i> <span>구독</span>
			</a>
		</aside>
		<div class="main-content">
			<nav>
				<a href="" class="active">전체</a> <a href="">음악</a> <a href="">게임</a>
				<a href="">뉴스</a> <a href="">라이브</a> <a href="">야생생물</a>
			</nav>
			<section>Lorem ipsum dolor sit amet consectetur adipisicing
				elit. Vel voluptatum rerum sequi ut ipsam commodi eaque at magnam
				culpa facilis perferendis nobis, obcaecati minus doloremque delectus
				aliquam pariatur magni deserunt! Deleniti labore architecto nemo
				tempora delectus dolores consequatur magni voluptas iure tenetur,
				saepe culpa minus sequi error repellat voluptates magnam doloremque
				ducimus molestiae ipsam officia? Similique tempore quos rerum alias.
				Officiis nobis nostrum doloribus commodi nam unde esse quidem,
				blanditiis voluptas veniam omnis! Magni doloribus quaerat natus a
				facilis quisquam repellendus rerum pariatur, tempore sint illum.
				Aliquid sequi eius sunt. Similique corrupti atque aspernatur odit
				eaque repudiandae odio, iusto quo maxime mollitia voluptatem. Qui,
				dolorum obcaecati. Dolorum impedit placeat deserunt, molestiae iste
				vitae non quidem facilis, saepe minus rem tempore! Illum inventore
				voluptate nesciunt ea veniam delectus repellendus doloremque! Porro
				tenetur pariatur corporis ducimus illum voluptatibus dolorem, saepe
				neque assumenda. Voluptatum ratione eligendi, iusto iure dolorum
				possimus? Voluptatibus, cupiditate molestias! Reiciendis, quia hic.
				Inventore odit similique rem quam possimus aliquid consectetur
				repudiandae, minima, temporibus porro delectus impedit. Sapiente
				asperiores dolor explicabo, nobis non ullam, labore iste sint nemo
				quisquam odit! Molestiae, voluptatem? Quam provident molestias ex
				porro quas nihil a excepturi delectus enim officia quos, temporibus
				deserunt rem. Ea quasi voluptatum nulla tempora doloremque
				voluptatem minima itaque, excepturi earum dolore. Inventore
				reiciendis excepturi aliquam quibusdam? Minima omnis veritatis quos
				accusamus dolor deserunt, numquam ducimus, itaque atque natus
				assumenda minus saepe. Quasi, natus qui. Delectus, ipsam nulla.
				Ratione enim nulla sunt? Fugit qui nisi sed odio inventore atque
				porro adipisci animi, rerum perferendis voluptatibus facilis iure
				iusto sit officiis hic fugiat eius harum maxime. Fugit neque
				laboriosam odit, sequi aspernatur velit! Nulla maxime autem odit
				numquam aperiam architecto doloribus mollitia, ipsum ipsam excepturi
				at animi quaerat, asperiores ad similique doloremque? Corporis odit
				voluptas aut, possimus labore ipsum? Tempore itaque quisquam
				voluptas. Quae repudiandae nostrum quidem in incidunt iste optio
				natus esse ut, dolor consequatur, magni dicta vitae hic deserunt
				laborum magnam ratione culpa ipsam nemo velit molestiae dignissimos
				nulla. Necessitatibus, praesentium! Veritatis cum officia natus unde
				officiis. Repudiandae asperiores soluta quam adipisci repellendus
				odit dolorem architecto iure reiciendis quasi nihil impedit
				consequuntur, saepe omnis magnam quibusdam alias voluptate accusamus
				ipsum nemo? Necessitatibus nulla ullam voluptatem ipsum voluptatum,
				architecto ab asperiores a reprehenderit eaque illo ducimus
				doloribus expedita facere ut exercitationem odit pariatur tempore,
				ea ipsam! Dicta harum cupiditate minima reprehenderit sunt? Vero
				molestias natus eligendi explicabo consectetur laborum ea, placeat
				voluptate, ducimus perferendis consequatur ab minima sunt maiores
				velit labore tempore necessitatibus quasi sapiente non autem. Ipsam
				numquam facilis reprehenderit nesciunt? Magni dolorem impedit
				inventore asperiores optio pariatur totam quis explicabo veritatis
				facere quidem unde adipisci illo aut fugit quod, saepe quisquam
				beatae odit dignissimos temporibus repellat illum ullam animi!
				Ipsam. Incidunt accusantium, accusamus earum exercitationem
				laboriosam magnam sint aliquam voluptatibus obcaecati minus ipsa
				tempore necessitatibus error excepturi dignissimos rerum sed placeat
				repellat vitae inventore eum maiores. Nisi similique aliquid omnis.
				Vitae nam sint laboriosam omnis iusto, fugit atque quo. Vitae
				eveniet voluptates iusto perferendis nam minus ad assumenda, modi
				debitis exercitationem soluta quae sit maiores fugiat a! Blanditiis,
				est quasi. A laudantium consequuntur voluptate minima! Numquam
				voluptates doloribus deleniti odio magni rem in quaerat excepturi
				incidunt iste illo provident harum tenetur nihil, animi dolores.
				Nulla corrupti omnis molestiae nemo unde! Facere nostrum nemo
				pariatur quisquam quo numquam possimus placeat molestias, veniam
				delectus fugit aliquid illum aut dolore quae minus quam nesciunt
				quod modi, at adipisci similique? Hic iste explicabo dolores?
				Sapiente laboriosam, id repellat, totam, quis accusantium numquam
				quidem provident dolores nesciunt quam laudantium dolorem. Voluptate
				corporis incidunt maiores, perferendis dolor itaque voluptas
				distinctio suscipit consequuntur, quasi cupiditate in unde!
				Voluptatem ab ad aspernatur iste eligendi dolorum, animi aliquam.
				Eos optio quasi iste vero! Suscipit placeat cupiditate et numquam
				itaque, at magnam, inventore ipsam reiciendis eveniet eaque modi
				tempore aut. Tempore eos facere magnam, aperiam placeat qui omnis,
				unde error quia laudantium iste quas delectus possimus molestiae
				cupiditate sequi provident saepe, tenetur inventore quidem ad
				doloribus. Eius enim autem repellat. Quasi praesentium doloremque at
				iusto quidem ab magni facere fugiat, assumenda temporibus quia
				officia dolor, quam blanditiis expedita eos a error quae amet
				adipisci incidunt rem. Impedit non ad ipsa? Saepe cumque veritatis
				id fugit cupiditate. Odit nemo illo iste animi saepe eligendi
				quaerat tempore a sed laudantium distinctio dolorem nobis, alias
				maxime doloremque facilis? Magnam, officiis! Animi, voluptatibus
				dolorem. Eos, quibusdam laudantium! Dolorem soluta necessitatibus,
				quisquam nostrum maxime vitae quasi nam ipsum quaerat dolore rem
				odit! Dolorum culpa eligendi consequuntur ratione quibusdam. Laborum
				necessitatibus eaque, harum culpa laudantium exercitationem.
				Quisquam commodi aliquam error, blanditiis quis delectus facere
				nihil et repudiandae obcaecati asperiores at exercitationem modi
				quas impedit quasi aperiam. Exercitationem animi eligendi aspernatur
				quos laudantium necessitatibus iusto reiciendis ab. Ratione harum
				placeat repellendus autem, iste deleniti, non enim deserunt
				obcaecati dolorem tempora dicta. Mollitia provident, quia, omnis
				placeat doloremque, repellat illo iure cupiditate fuga rem possimus
				quos voluptatibus quidem? Nostrum, perferendis fuga consequuntur
				amet corporis laborum nemo dolorum repellat excepturi saepe
				dignissimos adipisci doloremque hic expedita accusantium? Pariatur
				asperiores unde eos at fugiat obcaecati, fuga illum! Eligendi, quas
				possimus! At eius accusantium vel dignissimos eos nemo, recusandae
				ab? Suscipit eligendi odit doloremque iusto fugiat mollitia id
				deleniti, repellat tempora reprehenderit obcaecati consectetur quae
				sint veniam aliquam similique esse dicta. Voluptatibus molestiae
				obcaecati rerum debitis, ullam a tempore iusto consequuntur est!
				Accusamus asperiores nihil debitis deleniti labore expedita. Ipsam
				doloribus optio quae esse fuga nobis nisi est molestiae eos
				accusamus! Atque culpa consequuntur quos accusamus eos doloremque
				odit cupiditate, autem iure officia omnis vero ipsum voluptatum,
				placeat laudantium. Nam veritatis provident perferendis expedita
				nisi neque harum optio. Quidem, quisquam officiis. Molestias sit
				ullam, minus a exercitationem error culpa commodi accusantium
				voluptatum temporibus iste doloribus ad quasi deleniti eos
				reprehenderit rerum numquam tenetur dolores molestiae neque eligendi
				non facere. Saepe, illo. Voluptas error ratione iusto suscipit, quam
				dolorum recusandae, officia inventore enim maiores fugit quia
				similique soluta aspernatur. Quisquam at velit dolores, facere
				dolorem eveniet obcaecati impedit. Illum cumque dignissimos numquam?
				Nemo pariatur exercitationem, consequatur nisi unde accusantium
				eveniet inventore quidem voluptatem repudiandae, cum quo aliquam
				totam nam laborum, minima reiciendis? Eveniet amet deserunt
				explicabo iste, sequi hic accusantium unde inventore! Veniam vel
				doloremque quis maxime. Ut amet numquam sed aspernatur corporis, quo
				error accusantium dolorem impedit sunt eos, consequuntur maiores
				exercitationem incidunt repellat placeat laudantium laboriosam magni
				voluptatum! Adipisci, magnam. Natus nobis, sequi odio sit modi esse
				similique repellat veniam maxime officia laudantium laborum
				inventore tenetur temporibus ipsa eveniet perferendis fugit deleniti
				deserunt et iure doloribus sunt. Iusto, cumque dignissimos. Neque
				eveniet iste libero, reiciendis accusantium asperiores officia minus
				dicta amet rerum unde fugit voluptatem sint facilis veniam est quo
				magnam assumenda quaerat repudiandae deserunt in quam maxime
				aliquid? Expedita? Itaque eligendi iusto error magnam. Impedit odio
				distinctio itaque. Distinctio quam corporis neque consequuntur ipsam
				quidem odio beatae reprehenderit saepe eaque, ea praesentium numquam
				expedita quasi tempora cum, placeat rem. Nostrum, autem quo iste
				illo porro consequatur explicabo animi. Commodi beatae tempore
				accusantium nisi esse aspernatur modi eaque. Aliquam nihil mollitia
				itaque dicta quam. Itaque eligendi eum dolorem repudiandae
				molestias! Earum aperiam magni blanditiis, incidunt quidem modi
				voluptatibus eveniet nesciunt ducimus repellat ad? Tempore, porro
				sequi consectetur labore, reprehenderit quibusdam quod, eveniet
				corrupti expedita nesciunt at qui perferendis obcaecati. Iusto.
				Praesentium, non expedita. Dignissimos rem commodi qui reprehenderit
				ea, quaerat saepe tempore accusantium culpa eum consequuntur laborum
				voluptate eaque officiis iusto excepturi natus praesentium? Suscipit
				asperiores minus dolore pariatur voluptatibus. Accusantium explicabo
				totam accusamus quidem necessitatibus esse blanditiis dolor ducimus
				nostrum recusandae, dolores excepturi fugit aliquam labore sunt
				autem nisi molestias! Praesentium omnis deleniti tempora nihil
				adipisci odio ipsum debitis. Rerum illo assumenda earum sapiente
				consequuntur dolor necessitatibus ea quis magnam, laboriosam qui
				nisi placeat eos sit adipisci, accusantium cumque! Nemo placeat
				molestiae rem obcaecati officiis natus, tempora omnis aliquid.
				Dignissimos pariatur voluptates qui rem nihil dolorum consectetur
				fugiat totam. Similique ut neque culpa at nesciunt optio? Quam
				cumque tenetur eius iusto, odio, aperiam recusandae obcaecati,
				cupiditate odit nihil unde! Vero, in harum? In deleniti corrupti
				veritatis facere fugiat, provident maxime? Quas fuga eveniet atque
				laudantium deleniti cum, similique minima id minus beatae cumque
				provident commodi ea aperiam voluptatibus labore? Libero quasi
				reiciendis similique atque suscipit minus eveniet voluptatibus non
				quisquam quia magnam facere eius perspiciatis vero aliquid dolores
				vel nulla asperiores autem voluptatum quaerat, harum rerum. Error,
				praesentium voluptatibus. Iusto a molestias nisi, cupiditate cum
				debitis, dignissimos sint dolorum numquam atque sequi quas eaque
				inventore consequuntur et, impedit error! Id perferendis debitis
				aperiam consequuntur ullam quis numquam voluptates quod. Ullam nisi
				atque quam consequatur laborum totam laboriosam suscipit veniam
				quisquam est, reiciendis sequi. Fuga quo odio cumque iusto velit
				illo at quia, voluptatem repellendus! Alias deleniti deserunt veniam
				placeat! Sunt doloremque facilis, vitae id asperiores necessitatibus
				recusandae fuga soluta facere voluptatibus eos iusto reprehenderit
				eum sit amet quam dignissimos atque similique, non aut aliquam. Ab
				minus aliquam aut aliquid? Eveniet aut iusto inventore voluptate,
				labore reprehenderit in vero illum praesentium totam soluta quo
				placeat quibusdam? Sapiente expedita quam nisi quis nulla corporis
				unde iusto? Beatae nisi eum dolore perspiciatis. Quibusdam
				consequuntur nihil repudiandae repellat pariatur fugiat distinctio
				unde iure, voluptate inventore autem? Tempore consequuntur
				reprehenderit accusantium ea mollitia culpa saepe cum esse eum odit,
				omnis vitae maiores veritatis facilis. Magnam soluta vel ea, harum
				rerum ipsum quia saepe repudiandae esse nisi autem nemo, laboriosam
				tempore aspernatur inventore. Architecto nostrum necessitatibus
				beatae praesentium vel pariatur aliquam ducimus animi tenetur
				dolorem. Rerum atque reiciendis veniam explicabo eligendi dolore!
				Earum quas quasi rerum rem voluptas in ipsa cum numquam, sit
				nesciunt veritatis eum culpa dolores officiis, consectetur sunt
				facere possimus labore id! Consectetur culpa at quam aut, ipsum
				impedit suscipit odio blanditiis modi cumque assumenda deleniti
				molestiae explicabo sit esse non aperiam adipisci iste officia
				nesciunt aliquid corporis quibusdam fugiat. Aspernatur,
				exercitationem. Ex corporis dolorem, cumque quia voluptatum illum
				tempore temporibus porro. Minus deserunt obcaecati ratione optio
				recusandae animi, eius exercitationem, dignissimos dolorem eveniet
				beatae illo, incidunt ex cupiditate assumenda. Quae, totam!
				Voluptatem laboriosam provident dolor recusandae tempore pariatur,
				earum porro, tenetur dignissimos exercitationem eligendi ut neque
				reprehenderit corporis ex quisquam et tempora corrupti eaque,
				repellat eum? Quam explicabo accusantium sapiente labore. Iure quasi
				deleniti architecto exercitationem totam perspiciatis dolorum
				repellendus asperiores doloremque voluptas, atque esse accusantium,
				blanditiis quis perferendis ea culpa sapiente, aspernatur tempore
				provident maiores. Error, rerum? Harum, maxime ut? Voluptatem sit
				numquam porro. Tempora quia et ea quaerat accusamus sunt accusantium
				dignissimos non vitae ipsam eligendi molestias iste, reiciendis
				corrupti laudantium labore adipisci eos unde doloremque error
				suscipit odio? Excepturi qui possimus exercitationem officia nihil
				sed expedita quasi, nostrum incidunt illo commodi magni eos
				blanditiis corporis delectus? Nesciunt beatae hic deserunt incidunt
				distinctio delectus vero facere quam modi possimus. Praesentium
				laborum laudantium delectus debitis accusantium nulla,
				necessitatibus, incidunt ipsam suscipit porro aliquam facere dolorum
				sunt unde voluptates. Numquam commodi suscipit doloribus minus
				laudantium ipsam magnam corporis odio quo labore! Pariatur
				voluptatum debitis placeat, eos officia doloribus sapiente,
				quibusdam, iste iusto voluptatem maiores quod consectetur.
				Accusantium totam, impedit unde error sapiente aut. Odit, soluta
				iusto! Quibusdam numquam quasi dolore esse. Temporibus debitis aut
				suscipit, illum laboriosam nobis excepturi ut soluta laudantium
				dignissimos. Corrupti ullam, ipsum quam quidem labore excepturi.
				Culpa similique cum dolore corrupti eligendi? Praesentium minus
				ratione doloremque doloribus? Unde incidunt veritatis porro nisi
				similique doloribus facere sequi exercitationem non aut optio, totam
				alias tempora! Iusto perspiciatis facere quam minima harum totam
				aliquid illum, voluptatem animi placeat laborum enim! Dolore eveniet
				voluptate tempore aspernatur quibusdam dicta error dolor, sunt
				cupiditate non quos eius et, sequi distinctio, reiciendis nostrum
				repudiandae. Id dolore reiciendis, veritatis totam sint ab tempora
				magnam ea. Porro architecto dolorem voluptates ab suscipit sed
				provident, error ea nesciunt pariatur in similique, tempora
				laboriosam dolore quo necessitatibus natus quas non tempore eveniet
				eum praesentium ipsa. Corporis, similique nulla. Nesciunt voluptatum
				esse perspiciatis placeat reprehenderit, voluptatem atque qui alias.
				Quae perspiciatis quas quasi eaque fugiat error aliquid recusandae
				animi dicta. Perspiciatis error atque doloribus ipsum ullam, hic
				molestias ad! Ea quis fugit enim dicta sunt fuga? Ea, quod non,
				debitis voluptatibus saepe, tempore perspiciatis sint aliquam error
				inventore nesciunt cupiditate unde adipisci quas iusto accusamus
				magni architecto veniam repellat? Natus at sunt, ab eaque
				exercitationem pariatur nam nisi vel incidunt architecto quasi
				explicabo odio officiis neque tenetur voluptate officia! Odio
				ducimus voluptatibus veritatis saepe hic placeat cupiditate nemo
				fuga. Voluptatum iste cupiditate, ad est inventore repudiandae
				nesciunt repellendus dignissimos, possimus nostrum nobis, atque
				veniam hic explicabo ab quo repellat magni itaque. Blanditiis
				dolorem recusandae iusto quisquam illum voluptas ea! Molestiae, eum
				aut placeat recusandae voluptatem ratione corporis quos maxime
				laborum odio, veniam facilis dignissimos excepturi modi aperiam.
				Repellat, neque excepturi? Temporibus magni beatae optio odit fugit
				dolores odio sed. Magni ipsam eius natus ad, labore, accusamus
				placeat at ex quasi ratione aspernatur voluptatum repellat magnam!
				Vero, dicta fugit dolores repellendus voluptatum consequatur eum
				libero. Explicabo quod illo totam numquam? Illum, eveniet quisquam
				officiis, accusantium debitis odio molestiae nisi architecto
				possimus blanditiis doloribus aut perspiciatis quidem asperiores
				esse velit provident totam necessitatibus nulla veniam odit nostrum!
				Pariatur, vero dignissimos? Neque. Sed repudiandae voluptates
				officia commodi iure totam quisquam laudantium dolorum dolores quia
				cum asperiores, neque sapiente accusantium ratione, minima, dolore
				labore quis cumque praesentium accusamus quos est id! Reprehenderit,
				perspiciatis! Vel amet porro maxime asperiores dolorum consectetur
				odio autem magni, voluptates, debitis, eum fuga deleniti sapiente?
				Magnam, totam distinctio voluptatibus amet quos porro libero optio
				magni est nesciunt! Sint, cumque! Cumque amet qui eveniet quasi
				fugit harum inventore, explicabo fugiat labore maxime eius modi
				adipisci necessitatibus sed. Alias nisi nostrum sed quia inventore
				molestias consequatur possimus eum, id repudiandae expedita? Sequi
				et mollitia iusto error natus omnis, aperiam molestiae reiciendis
				nemo dolores enim molestias possimus quia? Quos, facere? Animi
				aspernatur autem eius ullam libero harum beatae maiores velit modi
				delectus. Et a delectus sequi id accusantium facilis voluptatem. Est
				recusandae alias assumenda sed ipsum iure exercitationem. Rerum
				exercitationem nobis sint repellendus. Sed delectus hic cum eveniet
				atque odit officia eligendi? Officiis esse quas officia aliquid
				illum, molestias a dicta neque eius aut cupiditate magni ullam
				doloribus eveniet dolorum ex quidem similique id. Modi, quas ex?
				Iusto esse repudiandae perspiciatis voluptatum. Molestiae vero
				maiores expedita tenetur impedit quaerat debitis, facilis tempore,
				fugit nisi consectetur numquam? Eveniet animi assumenda quia magnam
				adipisci obcaecati nam iure maxime earum ea. Optio saepe id magni?
				Tempora voluptate amet cumque fugit iste similique quaerat quos
				accusantium corporis impedit nesciunt quis ratione consectetur quas
				cum, autem, laborum cupiditate, odit perferendis at placeat.
				Repudiandae vero quod sequi eligendi! Eaque perspiciatis quaerat
				possimus hic fuga, rerum, odit similique quidem nemo dicta minus rem
				tempora laborum, iste minima expedita facere est. Nostrum cupiditate
				iste temporibus deserunt inventore sapiente fugiat suscipit! Fugiat
				et sint ducimus cupiditate nihil quisquam maiores praesentium,
				molestiae consequatur, est fugit ullam illo repudiandae voluptatum
				vero. Mollitia magnam omnis numquam vel excepturi soluta quibusdam
				quos, eveniet nostrum repudiandae? Consequuntur perspiciatis esse
				aut ratione aperiam officiis eum eius consequatur nesciunt commodi
				dolorum deserunt numquam id nam corporis, molestiae reprehenderit in
				facere a assumenda. Illo blanditiis repudiandae assumenda pariatur
				qui. Labore magnam officiis consequuntur non, unde quia error! In
				nihil officia ipsam sint unde quae. Tenetur possimus dicta quos ab
				consequuntur consectetur totam sint, autem corporis repellendus
				praesentium ratione et. Laborum delectus dolorem officia voluptatum
				pariatur fugiat illum ad esse fugit id rem, eveniet, minus eos
				repellat quibusdam suscipit necessitatibus quasi nobis expedita
				assumenda, quo minima! Sunt facilis molestiae praesentium?
				Voluptates suscipit quia nulla fugiat praesentium laborum
				dignissimos ea modi, quis maxime exercitationem, nobis, saepe ullam
				aperiam iure. Nisi maiores beatae, sunt aliquid adipisci dignissimos
				accusantium reiciendis perspiciatis ratione corporis. Placeat, fugit
				sapiente explicabo quos nam autem consequuntur reiciendis ullam eos
				officia, repellat voluptate nobis non incidunt earum tempora libero?
				Deserunt, ex reiciendis quia magni debitis iste eos dolore omnis?
				Odit veritatis temporibus ab nemo dicta laudantium deserunt. Nisi ea
				reprehenderit atque minima culpa repudiandae iure, vero assumenda,
				dolor hic in odio voluptate omnis fugit dolore? Numquam quo eum
				expedita. Facilis, architecto dolore culpa eaque odio, quo quae
				aperiam dicta veniam error aliquam ipsam soluta magni quam expedita
				ea rerum cupiditate assumenda voluptates consequuntur? Blanditiis
				veritatis nam quas enim suscipit! Quisquam reiciendis suscipit
				consectetur voluptas nam inventore? Dolore excepturi quo asperiores
				quos reiciendis, cum deserunt odio dolores voluptatibus doloribus
				sunt expedita at eius accusamus blanditiis, natus consectetur
				possimus voluptates sapiente? Blanditiis, dicta, explicabo ipsum ut,
				odio tenetur modi debitis molestias eligendi harum reiciendis earum
				aliquid labore nobis recusandae deleniti sint officia! Magnam,
				laborum fugiat qui beatae alias sunt veritatis officiis. Soluta
				amet, tempora sit asperiores voluptatem ab voluptate excepturi
				nostrum, sapiente consequuntur consequatur perferendis optio velit
				aperiam officiis sequi, delectus explicabo error. Illum, magnam
				sequi in eos est officia doloremque? Tempore, consectetur
				voluptatibus ipsam quae in, perferendis accusantium quisquam iure
				vero earum ullam expedita error nulla quia! Excepturi, quaerat.
				Voluptas maiores nostrum ullam ipsa ducimus unde, accusamus laborum
				corrupti similique. Sit eaque distinctio fuga quasi unde expedita
				laboriosam perspiciatis dignissimos optio, amet autem deleniti
				nulla, quis modi. Doloribus, pariatur, eos iure sequi eveniet est in
				repellat inventore laudantium assumenda corporis. Similique ex
				facere voluptatum delectus, quibusdam ratione perferendis quos.
				Rerum, facere. Dolor molestiae consequatur iusto nisi dicta placeat
				et quo ratione eius. Ratione sed quo doloremque itaque deserunt
				totam corporis! Ratione quaerat aliquid, omnis cumque libero aut
				doloremque esse harum, cum, optio officia! Officiis, itaque
				quibusdam eos facilis vitae maxime praesentium sit harum repellendus
				porro. Quasi accusantium natus ipsa beatae? Saepe numquam nobis
				illum qui maiores consequuntur, dignissimos doloribus sint iure hic
				quod aperiam, repellendus blanditiis libero sequi? Temporibus facere
				molestias id eos eum mollitia adipisci similique, est incidunt iste!
				Facilis sed possimus ipsam nobis repellat provident quaerat culpa
				blanditiis mollitia aliquid reiciendis id, perspiciatis doloremque
				ratione voluptatum, debitis aut unde quis minima tenetur tempora
				vel. Non totam inventore aut? Nihil, maxime dolores repudiandae
				nobis, suscipit, aliquam velit tempora laboriosam consequatur quod
				nisi. Doloribus repudiandae ullam consequatur iusto, omnis, sunt
				voluptatum vero at iure dolorum velit dignissimos quaerat a ea.
				Eaque praesentium sint assumenda numquam, maiores corrupti molestiae
				quia omnis quidem consequatur animi facilis ex voluptatibus iusto
				ipsa, vero id voluptates unde cumque nam illum! Et voluptate minima
				assumenda nostrum!</section>
		</div>
	</main>
	<script src="/youtube/script.js"></script>
</body>
</html>
