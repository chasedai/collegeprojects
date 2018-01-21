<?php
/**
 * Template Name: Full Width Template
 *
 * Displays pages in a Full Width Template.
 *
 * @package Enliven
 */

get_header(); ?>

<?php while( have_posts() ) : the_post(); ?>

    <?php get_template_part( 'template-parts/content', 'hero' ); ?>

<?php endwhile; ?>

<?php rewind_posts(); ?>

<div class="container">
    <div id="primary" class="content-area">
        <main id="main" class="site-main" role="main">

            <?php while ( have_posts() ) : the_post(); ?>

                <?php get_template_part( 'template-parts/content', 'page' ); ?>

               

            <?php endwhile; // End of the loop. ?>

        </main><!-- #main -->
    </div><!-- #primary -->
</div><!-- .container -->
<?php get_footer(); ?>
